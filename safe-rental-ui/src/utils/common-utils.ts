import useGeolocation from "react-hook-geolocation"

const geolocation = useGeolocation({
	enableHighAccuracy: true,
	maximumAge: 15000,
	timeout: 12000,
})
console.log(geolocation)
