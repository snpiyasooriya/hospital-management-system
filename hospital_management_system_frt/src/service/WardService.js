import axios from "axios";

class WardService {
    getWardsByLocation(location) {
        return axios.get('http://localhost:8081/api/ward/location', {
            params: { location: parseInt(location) }
        })
    }
}

export default new WardService()