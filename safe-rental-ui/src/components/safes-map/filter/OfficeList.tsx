import { Office } from '@/types/map-search.type'

type OfficeListProps = {
	offices: Office[]
	handleSelectedOffice: (office: Office) => void
}

const OfficeList = ({offices, handleSelectedOffice}: OfficeListProps) => {
	return (
		<div className='flex flex-col gap-4 font-mono'>
			{offices.map(office => (
				<div
					className='group/item hover:bg-slate-100 cursor-pointer'
					key={office.id}
					onClick={() => handleSelectedOffice(office)}
				>
					<div className='text-xl font-bold'>{office.address}</div>
					<div className='text-neutral-500 text-base'>
						Количество свободных сейфов: {office.safes.length}
					</div>
				</div>
			))}
		</div>
	)
}

export default OfficeList
