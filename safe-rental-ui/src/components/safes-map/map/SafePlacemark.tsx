import { OfficeWithoutSafes } from '@/types/map-search.type'
import { Placemark } from '@pbe/react-yandex-maps'
import { renderToString } from 'react-dom/server'
import styles from './safe-placemark.module.css'

type SafePlacemarkProps = {
	office: OfficeWithoutSafes
}
const SafePlacemark = ({ office }: SafePlacemarkProps) => (
	<Placemark
		key={office.id}
		// geometry={[office.coordinate.longitude, office.coordinate.latitude].map(c => c + (Math.random() - 0.6))}
		geometry={[office.coordinate.longitude, office.coordinate.latitude]}
		// onClick={handleMarkerClick}
		options={{
			iconLayout: 'default#image',
			iconImageSize: [30, 50],
			iconImageHref: `safe-icon.svg`,
		}}
		properties={{
			// balloonContentHeader: 'Office Name',
			balloonContentBody: renderToString(
				<BallonContext address={office.address} openAt={office.openAt} />
			),
			balloonContentFooter: ``,
			iconContent: ``,
		}}
	/>
)

const BallonContext = ({ address, openAt }: any) => {
	return (
		<div className={styles.balloonContent}>
			<h3>{address}</h3>
			<div>{openAt}</div>
			<div className=''>
				<div className='text-xl'>Время работы:</div>
				<div className='text-s text-gray-500'>
					пн-пт: <span className='font-bold'>10:00-19:00</span>
				</div>
			</div>
			<button>Рассчитать стоимость</button>
		</div>
	)
}

export default SafePlacemark
