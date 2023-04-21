import Image from 'next/image'
import { useRouter } from 'next/router'
import React from 'react'

type Props = {}

const Logo = () => {
	const router = useRouter()

	return (
		<Image
			alt='Safe-Rental'
			className='hidden md:block cursor-pointer'
			height='50'
			width='50'
			src='/safe-icon.svg'
            onClick={() => router.push('/')}
		/>
	)
}

export default Logo
