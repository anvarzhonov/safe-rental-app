import { FC } from 'react'
import Navbar from '../navbar/Navbar'
import RegisterModal from '../modals/RegisterModal'
import ToasterProvider from '@/providers/ToasterProvider'
import LoginModal from '../modals/LoginModal'

type LayoutProps = {
	children: React.ReactNode
}

const Layout: FC<LayoutProps> = ({ children }) => {
	return (
		<div>
			<ToasterProvider/>
			<Navbar />
			<RegisterModal/>
			<LoginModal/>
			<div className='pt-20'></div>
			{children}
		</div>
	)
}

export default Layout
