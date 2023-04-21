import { FC, PropsWithChildren } from 'react'
import Navbar from '../navbar/Navbar'

type Props = {}

const Layout: FC<PropsWithChildren<unknown>> = ({ children }) => {
	return (
		<div>
			<Navbar />
			<div className='pt-20'></div>
			{children}
		</div>
	)
}

export default Layout
