import { useRouter } from 'next/router';
import React from 'react'
import {BiSearch} from 'react-icons/bi';

const NavbarSearch = () => {
    const router = useRouter();

	return (
		<div
			className='
            border-[1px]
            w-full
            md:w-auto
            py-2 
            rounded-full 
            shadow-sm 
            hover:shadow-md 
            transition 
            '
		>
			<div className='flex flex-row items-center justify-between'>
				<div className='text-sm font-semibold px-6 cursor-pointer'>Тарифы</div>
				<div
					onClick={() => router.push('/rental-calc')}
					className='hidden sm:block text-sm font-semibold px-6 border-x-[1px] flex-1 text-center cursor-pointer'
				>
					Расчет стоимости
				</div>
				<div
					onClick={() => router.push('/map')}
					className='text-sm pl-6 pr-2 text-gray-600 flex flex-row items-center gap-3 cursor-pointer'
				>
					<div className='hidden sm:block'>Свободные сейфы</div>
					<div className='p-2 bg-green-500 rounded-full text-white'>
						<BiSearch />
					</div>
				</div>
			</div>
		</div>
	)
}

export default NavbarSearch
