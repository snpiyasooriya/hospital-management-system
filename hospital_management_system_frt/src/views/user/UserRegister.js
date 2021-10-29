import React, { useState, useEffect } from 'react'
import axios from 'axios'
import UserTypeService from 'src/service/UserTypeService';
import LocationService from 'src/service/LocationService';
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


const UserRegister = () => {
  const [collapsed, setCollapsed] = React.useState(true)
  const [showElements, setShowElements] = React.useState(true)
  const [location, setlocation] = useState([])
  const [userType, setuserType] = useState([])
  const [newDoctor, setnewDoctor] = useState({
    title: '',
    firstName: '',
    lastName: '',
    address: '',
    dob: '',
    nic: '',
    phone: '',
    email: '',
    type: '',
    location: ''

  })

  useEffect(() => {
    getLocation()
    getUsertypes()
  }, [])


  const getLocation = async () => {
    LocationService.getLocations().then(e => setlocation(e.data))
  }

  const getUsertypes = async () => {
    UserTypeService.getUsertypes().then(e => {
      setuserType(e.data)
    })
  }

  const handleSubmit = async (e) => {
    e.preventDefault()
    const data = JSON.stringify(newDoctor)
    const res = await axios.post('http://localhost:8081/api/user', data, {
      headers: {
        'Content-Type': 'application/json'
      }
    })
    console.log(res)
  }



  const handleChange = (e) => {
    const data = { ...newDoctor }
    data[e.id] = e.val
    setnewDoctor({
      ...data
    })
    console.log(newDoctor)
  }

  return (
    <>

      <CCard >
        <CCardHeader>
          User Registration
        </CCardHeader>
        <CCardBody>
          <CForm action="" method="post" className="form-horizontal">

            <CFormGroup row>
              <CCol md="3">
                <CLabel htmlFor="firstName">First Name</CLabel>
              </CCol>
              <CCol xs="12" md="9">
                <CInput id="firstName" name="firstName" placeholder="Enter First Name" onChange={e => handleChange({ val: e.target.value, id: e.target.id })} />

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
                <CLabel htmlFor="nic">NIC</CLabel>
              </CCol>
              <CCol xs="12" md="9">
                <CInput id="nic" name="nic" placeholder="Enter NIC" onChange={e => handleChange({ val: e.target.value, id: e.target.id })} />
              </CCol>
            </CFormGroup>

            <CFormGroup row>
              <CCol md="3">
                <CLabel htmlFor="address">Address</CLabel>
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
                <CLabel htmlFor="type">User Type</CLabel>
              </CCol>
              <CCol xs="12" md="9">
                <CSelect custom name="type" id="type" onChange={e => handleChange({ val: e.target.value, id: e.target.id })}>
                  {userType.map((ut, i) => {
                    return (<option value={ut.id} key={ut.id}>{ut.type}</option>)
                  })}
                </CSelect>
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
          <CButton type="reset" size="sm" color="danger"><CIcon name="cil-ban" /> Reset</CButton>
        </CCardFooter>
      </CCard>

    </>
  )
}

export default UserRegister
