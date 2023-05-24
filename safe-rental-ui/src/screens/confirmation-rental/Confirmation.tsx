import { SafeRentalContext } from '@/contexts/SafeRentalContext'
import { Button } from '@mui/material'
import { useRouter } from 'next/router'
import { useContext } from 'react'

const ConfirmationRental = () => {
	const router = useRouter()
	const { daysRental, totalSum, size, office } = useContext(SafeRentalContext)!

	return (
		<div className='container mx-auto font-mono text-center'>
			<h1 className='text-3xl py-5'>Выбранные условия</h1>
			<div className='flex flex-col gap-3'>
				<h2>Аренда сейфа</h2>
				<p>Количество дней аренды: {daysRental}</p>
				<p>Выбранный размер сейфа: {size}</p>
				<p>Выбранный офис: {office?.address}</p>
				<p>Итоговая сумма аренды: {totalSum}</p>

				<div className='button'>
					<Button variant='contained' className='bg-green-600' onClick={() => router.push('/payment')}>
						Продолжить
					</Button>
				</div>
			</div>
		</div>
	)
}

export default ConfirmationRental
