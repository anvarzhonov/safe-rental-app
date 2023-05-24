import { Office } from '@/types/map-search.type'
import { TextField } from '@mui/material'
import { ChangeEvent, FC } from 'react'
import OfficeList from './OfficeList'

type OfficesFilterProps = {
	error: boolean
	offices: Office[]
	filteredOffices: Office[]
	onFilterChange: (filteredOffices: Office[]) => void
	handleSelectedOffice: (office: Office) => void | undefined
}

const OfficesFilter: FC<OfficesFilterProps>	= ({
	error,
	offices,
	filteredOffices,
	onFilterChange,
	handleSelectedOffice}) => {
		
	const handleTextInputChange = (event: ChangeEvent<HTMLInputElement>) => {
		const { value } = event.target

		const filteredOffices = offices.filter(office =>
			office.address.toLowerCase().includes(value.toLowerCase())
		)

		onFilterChange(filteredOffices)
	}

	return (
		<>
			<TextField
				id='filled-basic'
				label='Поиск'
				variant='standard'
				className='w-full'
				onChange={handleTextInputChange}
			/>
			<div className='text-2xl font-medium  mt-5'>
				{error || filteredOffices.length === 0 ? (
					<h1>no offices found</h1>
				) : (
					<OfficeList
						offices={filteredOffices.length > 0 ? filteredOffices : offices}
						handleSelectedOffice={handleSelectedOffice}
					/>
				)}
			</div>
		</>
	)
}

export default OfficesFilter

