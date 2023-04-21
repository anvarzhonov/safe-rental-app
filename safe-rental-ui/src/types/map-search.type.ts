export interface IOffices {
	offices: Office[]
}

export interface Office {
    id: number,
	address: string
	openAt: string
	coordinate: Coordinate
	safes: Safe[]
}

export interface OfficeWithoutSafes extends Omit<Office, 'safes'> {}

export interface Coordinate {
	latitude: number
	longitude: number
}

export interface Safe {
	id: number
	size: string
}
