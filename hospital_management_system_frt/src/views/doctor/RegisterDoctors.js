import React, { useState, useEffect } from 'react'
import axios from 'axios'
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
    CSelect
} from '@coreui/react'
import CIcon from '@coreui/icons-react'

const DoctorRegister = () => {
    const [collapsed, setCollapsed] = React.useState(true)
    const [showElements, setShowElements] = React.useState(true)
    const [specialist, setspecialist] = useState([])
    const [location, setlocation] = useState([])
    const [newDoctor, setnewDoctor] = useState({
        firstName: '',
        lastName: '',
        address: '',
        dob: '',
        nic: '',
        phone: '',
        email: '',
        specialist: '',
        location: ''

    })

    useEffect(() => {
        getSpecialist()
        getLocation()
    }, [])

    const getSpecialist = async () => {
        axios.get('http://localhost:8081/api/specialist').then(e => setspecialist(e.data));

    }

    const getLocation = async () => {
        axios.get('http://localhost:8081/api/location').then(e => setlocation(e.data))
    }

    const handleSubmit = async (e) => {
        e.preventDefault()
        const data = JSON.stringify(newDoctor)
        const res = await axios.post('http://localhost:8081/api/doctor', data, {
            headers: {
                'Content-Type': 'application/json'
            }
        })
        console.log(res.status)
        switch (res.status) {
            case 201:
                alert("Saved Successfully")
                break;

            default:
                break;
        }
    }



    const handleChange = (e) => {
        const data = { ...newDoctor }
        data[e.id] = e.val
        setnewDoctor({
            ...data
        })
        console.log(newDoctor)
    }

    const handleReset = (e) => {
        window.location.reload(true);
    }

    return (
        <>

            <CCard >
                <CCardHeader>
                    Doctor Registration
                </CCardHeader>
                <CCardBody>
                    <CForm action="" method="post" className="form-horizontal needs-validation">
                        <CFormGroup row>
                            <CCol md="3">
                                <CLabel htmlFor="firstName">First Name</CLabel>
                            </CCol>
                            <CCol xs="12" md="9">
                                <CInput type="text" required id="firstName" name="firstName" placeholder="Enter First Name" onChange={e => handleChange({ val: e.target.value, id: e.target.id })} />

                            </CCol>
                        </CFormGroup>
                        <CFormGroup row>
                            <CCol md="3">
                                <CLabel htmlFor="lastName">Last Name</CLabel>
                            </CCol>
                            <CCol xs="12" md="9">
                                <CInput id="lastName" name="lastName" placeholder="Enter Last Name" onChange={e => handleChange({ val: e.target.value, id: e.target.id })} />
                            </CCol>
                        </CFormGroup>
                        <CFormGroup row>
                            <CCol md="3">
                                <CLabel htmlFor="specialist">Speciality</CLabel>
                            </CCol>
                            <CCol xs="12" md="9">
                                <CSelect custom name="specialist" id="specialist" onChange={e => handleChange({ val: e.target.value, id: e.target.id })}>
                                    {specialist.map((spec, i) => {
                                        return (<option value={spec.id} key={spec.id}>{spec.name}</option>)
                                    })}
                                </CSelect>
                            </CCol>
                        </CFormGroup>
                        <CFormGroup row>
                            <CCol md="3">
                                <CLabel htmlFor="address">address</CLabel>
                            </CCol>
                            <CCol xs="12" md="9">
                                <CInput id="address" name="address" placeholder="Enter Address" onChange={e => handleChange({ val: e.target.value, id: e.target.id })} />
                            </CCol>
                        </CFormGroup>
                        <CFormGroup row>
                            <CCol md="3">
                                <CLabel htmlFor="dob">Date Of Birth</CLabel>
                            </CCol>
                            <CCol xs="12" md="9">
                                <CInput type="date" id="dob" name="dob" placeholder="Enter The Date Of Birth" onChange={e => handleChange({ val: e.target.value, id: e.target.id })} />
                            </CCol>
                        </CFormGroup>
                        <CFormGroup row>
                            <CCol md="3">
                                <CLabel htmlFor="nic">NIC</CLabel>
                            </CCol>
                            <CCol xs="12" md="9">
                                <CInput id="nic" name="nic" placeholder="Enter NIC" onChange={e => handleChange({ val: e.target.value, id: e.target.id })} />
                            </CCol>
                        </CFormGroup>
                        <CFormGroup row>
                            <CCol md="3">
                                <CLabel htmlFor="phone">Phone Number</CLabel>
                            </CCol>
                            <CCol xs="12" md="9">
                                <CInput id="phone" name="phone" placeholder="Enter The Phone Number" onChange={e => handleChange({ val: e.target.value, id: e.target.id })} />
                            </CCol>
                        </CFormGroup>
                        <CFormGroup row>
                            <CCol md="3">
                                <CLabel htmlFor="email">Email Address</CLabel>
                            </CCol>
                            <CCol xs="12" md="9">
                                <CInput type="email" id="email" name="email" placeholder="Enter Email" autoComplete="email" onChange={e => handleChange({ val: e.target.value, id: e.target.id })} />

                            </CCol>
                        </CFormGroup>
                        <CFormGroup row>
                            <CCol md="3">
                                <CLabel htmlFor="location">Hospital</CLabel>
                            </CCol>
                            <CCol xs="12" md="9">
                                <CSelect custom name="location" id="location" onChange={e => handleChange({ val: e.target.value, id: e.target.id })}>
                                    {location.map((spec, i) => {
                                        return (<option value={spec.id} key={spec.id}>{spec.name}</option>)
                                    })}
                                </CSelect>
                            </CCol>
                        </CFormGroup>
                    </CForm>

                </CCardBody>
                <CCardFooter>
                    <CButton type="submit" size="sm" color="primary" onClick={e => handleSubmit(e)} ><CIcon name="cil-scrubber" /> Submit</CButton>
                    <CButton type="reset" size="sm" color="danger" onClick={e => handleReset()} ><CIcon name="cil-ban" /> Reset</CButton>
                </CCardFooter>
            </CCard>

        </>
    )
}

export default DoctorRegister
