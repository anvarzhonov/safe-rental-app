import { Office, OfficeWithoutSafes, Safe } from '@/types/map-search.type'

export const calculateCountAvailableSafes = (safes: Safe[]) => {
	return safes.length
}

export const officeInfoMapToWithoutSafes = (
	offices: Office[]
): OfficeWithoutSafes[] =>
	offices.map((office: Office) => {
		const { id, address, openAt, coordinate } = office
		return {
			id,
			address,
			openAt,
			coordinate,
		}
	})

export const fakeResponse = {
		offices: [
		{
			id: 1,
			address: 'Ул. Радищева, дом 1',
			openAt: '2023-04-15 23:36:52',
			coordinate: {
				latitudeCoordinate: 38.53093449867246,
				longitudeCoordinate: 52.74125527661501,
			},
			safes: [
				{
					id: 0,
					size: 'XS',
				},
				{
					id: 1,
					size: 'XS',
				},
				{
					id: 2,
					size: 'XS',
				}
			],
		},
		{
			id: 2,
			address: 'Кутузовский проспект, 32 к 1',
			openAt: '2023-04-15 23:36:52',
			coordinate: {
				latitudeCoordinate: 31.53093449867246,
				longitudeCoordinate: 52.74125527661501,
			},
			safes: [
				{
					id: 0,
					size: 'XS',
				},
				{
					id: 1,
					size: 'XS',
				},
				{
					id: 2,
					size: 'XS',
				},
				{
					id: 3,
					size: 'XS',
				},
			],
		},
		{
			id: 3,
			address: 'Широкая ул, д. 1 к 4',
			openAt: '2023-04-15 23:36:52',
			coordinate: {
				latitudeCoordinate: 34.51093449867246,
				longitudeCoordinate: 56.74125527661501,
			},
			safes: [
				{
					id: 0,
					size: 'XS',
				},
				{
					id: 1,
					size: 'XS',
				},
				{
					id: 2,
					size: 'XS',
				},
				{
					id: 3,
					size: 'XS',
				},
			],
		},
		{
			id: 4,
			address: 'Полярный проспект 53',
			openAt: '2023-04-15 23:36:52',
			coordinate: {
				latitudeCoordinate: 37.53093449837246,
				longitudeCoordinate: 55.74115527661501,
			},
			safes: [
				{
					id: 0,
					size: 'XS',
				},
				{
					id: 1,
					size: 'XS',
				},
				{
					id: 2,
					size: 'XS',
				},
				{
					id: 3,
					size: 'XS',
				},
			],
		},
	],
}
