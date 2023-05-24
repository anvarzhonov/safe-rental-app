'use client';

import { useSafeRentalContext } from '@/hooks/context-hooks';
import { OfficeWithoutSafes } from '@/types/map-search.type';
import { Placemark } from '@pbe/react-yandex-maps';
import Link from 'next/link';
import { useRouter } from 'next/router';
import { FC } from 'react';
import { renderToString } from 'react-dom/server';

type SafePlacemarkProps = {
  office: OfficeWithoutSafes;
};
const SafePlacemark: FC<SafePlacemarkProps> = ({ office }) => {
  const router = useRouter();
  const { setOffice } = useSafeRentalContext();

  const handleSelectedOffice = (event: any) => {
    console.log(event.target.value);
    event.preventDefault();
    setOffice(office);
    router.push('/rental-calc');
    router.reload();
  };
  return (
    <Placemark
      key={office.id}
      // geometry={[office.coordinate.longitude, office.coordinate.latitude].map(c => c + (Math.random() - 0.6))}
      geometry={[
        office.coordinate.longitudeCoordinate,
        office.coordinate.latitudeCoordinate,
      ]}
      // onClick={handleMarkerClick}
      options={{
        iconLayout: 'default#image',
        iconImageSize: [30, 50],
        iconImageHref: `safe-icon.svg`,
      }}
      properties={{
        // balloonContentHeader: 'Office Name',
        balloonContentBody: renderToString(
          <BallonContext
            address={office.address}
            openAt={office.openAt}
            onClick={handleSelectedOffice}
          />
        ),
        balloonContentFooter: ``,
        iconContent: ``,
      }}
    />
  );
};

const BallonContext = ({ address, openAt, handleSelectedOffice }: any) => {
  return (
    <div className='rounded bg-white p-1 shadow'>
      <div className='text-xl'>{address}</div>
      <div>{openAt}</div>
      <div className='text-base'>
        <p>{openAt}</p>
        <p className='text-gray-500'>
          <span className='font-bold'>Время работы</span> пн-пт:{' '}
          <span className='font-bold'>10:00-19:00</span>
        </p>
      </div>
      <div className='mt-3 text-center'>
        <Link
          // variant='contained'
          className='w-full rounded bg-green-600 px-4 py-2 text-center text-white'
          onClick={handleSelectedOffice}
          href={'/rental-calc'}
        >
          Рассчитать стоимость
        </Link>
      </div>
    </div>
  );
};

export default SafePlacemark;
