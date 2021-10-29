import {
    CButton,
    CCard,
    CCardBody,
    CCardFooter,
    CCardHeader,
    CCol,
    CForm,
    CFormGroup,
    CInput,
    CLabel,
    CSelect,
    CDataTable,
    CBadge
} from '@coreui/react'
import './patient.css'
import CIcon from '@coreui/icons-react'
import PatientService from 'src/service/PatientService'
import LocationService from 'src/service/LocationService'
import WardService from 'src/service/WardService';
import { useState, useEffect } from 'react'

const getBadge = status => {
    switch (status) {
        case 1: return 'success'
        case 0: return 'warning'
        default: return 'primary'
    }
}
const fields = ['id', 'title', 'firstName', 'lastName', 'dob', 'nationality', 'nic', 'admit']

const AdmitPatient = () => {

    const [patients, setpatients] = useState([])
    const [locations, setlocations] = useState([])
    const [wards, setwards] = useState([])
    const [selectedLocation, setselectedLocation] = useState('')
    const [selectedWard, setSelectedWard] = useState('')
    const [selectedPatient, setselectedPatient] = useState('')
    const [patientDischarge, setpatientDischarge] = useState([])
    const [patientsAll, setPatientsAll] = useState([])




    const getPatientsForAdmit = async () => {
        PatientService.getPatientsForAdmit().then(e => {
            setpatients(e.data)
        })
    }

    const getPatients = async () => {
        PatientService.getPatients().then(e => {
            setPatientsAll(e.data)
        })
    }

    const getLocations = async () => {
        LocationService.getLocations().then(e => {
            setlocations(e.data)
        })
    }

    const getWardsByLocation = async (e) => {
        WardService.getWardsByLocation(e).then(e => {
            setwards(e.data)
        })
    }

    const getPatientsForDischarge = async (e) => {
        PatientService.getPatientsForDischarge(e).then(e => {
            setpatientDischarge(e.data)
        })
    }

    const handleSubmit = async () => {
        PatientService.updatePatientLocation(selectedLocation, selectedPatient, selectedWard)
        window.location.reload(true);
    }

    const handleSubmitDischarge = async () => {
        PatientService.dischargePatient(selectedPatient)
        window.location.reload(true);
    }

    const scopedSlots = {
        'title':
            (item) => (
                <td>
                    {item.title.name}

                </td>
            ),

        'admit': (item) => (
            <td>
                <CBadge color={getBadge(item.admit)}>
                    {item.admit == 1 ? "Admited" : item.admit === 0 ? "Discharged" : ""}
                </CBadge>
            </td>
        )

    }


    useEffect(() => {
        getPatientsForAdmit()
        getLocations()
        getPatientsForDischarge()
        getPatients()
    }, [])

    console.log(selectedPatient)
    return (
        <div>
            <CCard >
                <CCardHeader>
                    Admit Patient
                </CCardHeader>
                <CCardBody>
                    <CSelect size="sm" className="cs-select" custom name="title" id="title" onChange={e => setselectedPatient(e.target.value)}>
                        <option>Please Select Patient</option>
                        {patients.map((patient, i) => {
                            return (<option value={patient.id} key={patient.id}>{`${patient.firstName} ${patient.lastName} (${patient.id})`}</option>)
                        })}
                    </CSelect>
                    <CSelect size="sm" className="cs-select" custom name="title" id="title" onChange={e => { getWardsByLocation(e.target.value); setselectedLocation(e.target.value) }}>
                        <option>Please Select Hospital</option>
                        {locations.map((location, i) => {
                            return (<option value={location.id} key={location.id}>{location.name}</option>)
                        })}
                    </CSelect>
                    <CSelect size="sm" className="cs-select" custom name="title" id="title" onChange={e => {
                        setSelectedWard(e.target.value)
                    }}>
                        <option>Please Select Ward</option>
                        {wards.map((ward, i) => {
                            return (<option value={ward.id} key={ward.id}>{ward.ward}</option>)
                        })}
                    </CSelect>
                    <CButton type="submit" size="sm" color="primary" onClick={e => { handleSubmit(); getPatients() }}><CIcon name="cil-scrubber" /> Admit</CButton>
                </CCardBody>
            </CCard>
            <CCard >
                <CCardHeader>
                    Discharge Patient
                </CCardHeader>
                <CCardBody>
                    <CSelect size="sm" className="cs-select" custom name="title" id="title" onChange={e => setselectedPatient(e.target.value)}>
                        <option>Please Select Patient</option>
                        {patientDischarge.map((patient, i) => {
                            return (<option value={patient.id} key={patient.id}>{`${patient.firstName} ${patient.lastName} (${patient.id})`}</option>)
                        })}
                    </CSelect>

                    <CButton type="submit" size="sm" color="primary" onClick={e => { handleSubmitDischarge(); getPatients() }}><CIcon name="cil-scrubber" /> Discharge</CButton>
                </CCardBody>
            </CCard>
            <CCard >
                <CCardHeader>
                    Patient Details
                </CCardHeader>
                <CCardBody>
                    <CDataTable
                        items={patientsAll}
                        fields={fields}
                        hover
                        striped
                        bordered
                        size="sm"
                        itemsPerPage={10}
                        pagination
                        sorter
                        tableFilter
                        scopedSlots={scopedSlots}


                    />
                </CCardBody>
            </CCard>
        </div >
    )
}

export default AdmitPatient
