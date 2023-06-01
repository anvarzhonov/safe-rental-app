import SafesMap from '@/components/safes-map/map/OfficesMap'
import { Button } from '@mui/material';
import Image from 'next/image';
import { useRouter } from 'next/router';

type Props = {}

const Home = () => {
	const router = useRouter();
	return (
    <div className='container mx-auto flex items-center justify-between gap-3'>
      <div className='content-info flex flex-col gap-4 font-serif'>
        <p className='text-3xl font-semibold'>Аренда сейфов</p>
        <span className='text-sm font-medium'>
          Надёжный способ сохранить ценности или рассчитаться при крупной сделке
        </span>
        <Button
          variant='contained'
          className='bg-green-600'
          onClick={() => router.push('/map')}
        >
          Найти офисы
        </Button>
        <Button
          variant='contained'
          className='bg-green-600'
          onClick={() => router.push('/rental-calc')}
        >
          Рассчитать стоимость аренды
        </Button>
      </div>
      <div className='pt-24'>
        <Image
          height={360}
          width={570}
          alt=''
          src='/home-image.png'
          className='rounded-lg shadow-md shadow-black/5 dark:shadow-black/30'
        />
      </div>
    </div>
  );
}

export default Home
