'use client';

import getOffices from '@/service/map-search.service';
import { Office } from '@/types/map-search.type';
import { officeInfoMapToWithoutSafes } from '@/utils/safe-utils';
import { useEffect, useRef, useState } from 'react';
import OfficesFilter from '../../components/safes-map/filter/OfficesFilter';
import OfficesMap from '../../components/safes-map/map/OfficesMap';
import { toast } from 'react-hot-toast';

const SearchMap = () => {
  const [offices, setOffices] = useState<Office[]>([]);
  const [filteredOffices, setFilteredOffices] = useState<Office[]>([]);
  const [error, setError] = useState(false);
  const mapRef = useRef<ymaps.Map>();

  useEffect(() => {
    const fetchOffices = async () => {
      const response = await getOffices();
      if (response.status === 200) {
        const offices = response.data!.offices;

        setOffices(offices);
        setFilteredOffices(offices);
      } else {
        setError(true);
        toast.error('Произошла ошибка во время загрузки офисов');
      }
    };

    fetchOffices();
    // console.log(offices)
    // setOffices(fakeResponse.offices)
    // setFilteredOffices(fakeResponse.offices)
  }, []);

  const handleFilterChange = (filteredOffices: Office[]) => {
    setFilteredOffices(filteredOffices);
  };

  const handleSelectedOffice = (office: Office) => {
    const selectedCoordinates = [
      office.coordinate.longitudeCoordinate,
      office.coordinate.latitudeCoordinate,
    ];

    // переставляем положение камеры на выбранный пользователем офис
    mapRef.current?.panTo(selectedCoordinates, {
      flying: true,
      duration: 1500,
    });
  };

  return (
    <div className='flex'>
      <div className='w-2/4 pl-3 pr-10'>
        <OfficesFilter
          error={error}
          offices={offices}
          filteredOffices={filteredOffices}
          onFilterChange={handleFilterChange}
          handleSelectedOffice={handleSelectedOffice}
        />
      </div>
      <div className='basis-full'>
        <OfficesMap
          officeInfos={officeInfoMapToWithoutSafes(filteredOffices)}
          mapRef={mapRef}
        />
      </div>
    </div>
  );
};

export default SearchMap;
