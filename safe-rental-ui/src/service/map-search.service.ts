import { IOffices } from '@/types/map-search.type';
import { getAPI } from './api/http-common';

export default async function getOffices() {
	return await getAPI<IOffices>('map/findOfficesWithAvailableSafes')
}
