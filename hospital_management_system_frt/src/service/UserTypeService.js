import axios from "axios";
// import authHeader from "./auth.headers";

class UserTypeService {
    getUsertypes() {
        return axios.get('http://localhost:8081/api/usertype')
    }
}

export default new UserTypeService()