'use client'

import { Map, YMaps } from '@pbe/react-yandex-maps'
import { FC, MutableRefObject } from 'react'
import { Coordinate, OfficeWithoutSafes } from '../../../types/map-search.type'
import SafePlacemark from './SafePlacemark'

// const handleGeolocationChange = (event: any) => {
// 	const { position } = event.geoObjects.get(0).geometry
// 	console.log(position)

// 	setMapCenter([position[0], position[1]])
// 	setMapCenter(center)
// }

type OfficeMapProps = {
	officeInfos: OfficeWithoutSafes[]
	mapCenter?: Coordinate
	mapRef: MutableRefObject<ymaps.Map | undefined>
}


const mapCenter = [55.74125527661501, 37.53093449867246]

const OfficesMap: FC<OfficeMapProps> = ({ officeInfos, mapRef }) => {
	return (
		<>
			<YMaps
				query={{
					load: 'package.full',
					// apikey: '4fae456e-8206-4a6f-95e4-9e558e668b9a',
				}}
			>
				<Map
					defaultState={{
						center: mapCenter,
						zoom: 15,
						controls: ['geolocationControl'],
					}}
					modules={['control.ZoomControl', 'geocode']}
					// onGeolocationChange={handleGeolocationChange}
					width={'100%'}
					height={'100vh'}
					instanceRef={mapRef}
				>
					{/* <GeolocationControl options={{ float: 'right' }} /> */}
					{officeInfos.map((office) => (
						<SafePlacemark key = {office.id} office={office} />
					))}
				</Map>
			</YMaps>
		</>
	)
}

export default OfficesMap
