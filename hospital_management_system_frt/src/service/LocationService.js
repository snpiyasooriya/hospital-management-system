import axios from "axios";
// import authHeader from "./auth.headers";

class LocationService {
    getLocations() {
        return axios.get('http://localhost:8081/api/location')
    }
}

export default new LocationService()