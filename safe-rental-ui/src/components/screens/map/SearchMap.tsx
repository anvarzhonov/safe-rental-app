import getOffices from '@/service/map-search.service'
import { Office } from '@/types/map-search.type'
import { fakeResponse, officeInfoMapToWithoutSafes } from '@/utils/safe-utils'
import { useEffect, useRef, useState } from 'react'
import OfficesFilter from '../../safes-map/filter/OfficesFilter'
import OfficesMap from '../../safes-map/map/OfficesMap'

const SearchMap = () => {
	const [offices, setOffices] = useState<Office[]>([])
	const [filteredOffices, setFilteredOffices] = useState<Office[]>([])
	const [error, setError] = useState(false)
	const mapRef = useRef<ymaps.Map>()

	useEffect(() => {
		const fetchOffices = async () => {
			const response = await getOffices()
			if (response.status === 200) {
				setOffices(response.data.offices)
			} else {
				setError(true)
				alert('произошла ошибка во время загрузки офисов')
			}
		}

		// fetchOffices()
		setOffices(fakeResponse.offices)
		setFilteredOffices(fakeResponse.offices)
	}, [])

	const handleFilterChange = (filteredOffices: Office[]) => {
		setFilteredOffices(filteredOffices)
	}

	const handleSelectedOffice = (office: Office) => {
		const selectedCoordinates = [
			office.coordinate.longitude,
			office.coordinate.latitude,
		]

		// переставляем положение камеры на выбранный пользователем офис
		mapRef.current?.panTo(selectedCoordinates, {
			flying: true,
			duration: 1500,
		})
	}

	return (
		<div className='flex'>
			<div className='w-2/4 pl-3 pr-10'>
				<OfficesFilter
					error={error}
					offices={offices}
					filteredOffices={filteredOffices}
					onFilterChange={handleFilterChange}
					handleSelectedOffice={handleSelectedOffice}
				/>
			</div>
			<div className='basis-full'>
				<OfficesMap
					officeInfos={officeInfoMapToWithoutSafes(filteredOffices)}
					mapRef={mapRef}
				/>
			</div>
		</div>
	)
}

export default SearchMap
