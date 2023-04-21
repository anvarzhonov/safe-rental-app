import Link from 'next/link'
import { FC } from 'react'

const Header: FC = () => {
  return (
    <header className='flex justify-center'>  
    <Link href= '/'>Home</Link>
    <Link href= '/safes'>Safes</Link>
    <Link href= '/account'>Account</Link>
    </header>
  )
}

export default Header;