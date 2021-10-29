import axios from "axios";
// import authHeader from "./auth.headers";

class PatientService {
    getPatients() {
        return axios.get('http://localhost:8081/api/patient')
    }

    getPatientsForAdmit() {
        return axios.get('http://localhost:8081/api/patient/admit')
    }

    getPatientsForDischarge() {
        return axios.get('http://localhost:8081/api/patient/discharge')
    }

    updatePatientLocation(location, id, wid) {
        return axios.put('http://localhost:8081/api/patient/admit/' + parseInt(location) + '/' + parseInt(id) + '/' + parseInt(wid), {
            location: parseInt(location),
            id: parseInt(id)
        })
    }

    dischargePatient(id) {
        return axios.put('http://localhost:8081/api/patient/discharge/' + parseInt(id), {

        })
    }

    transferPatient(location, id) {
        return axios.put('http://localhost:8081/api/patient/' + parseInt(location) + '/' + parseInt(id), {

        })
    }
}

export default new PatientService()