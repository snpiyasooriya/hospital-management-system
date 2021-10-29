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

const CreatePatient = () => {
  const [collapsed, setCollapsed] = React.useState(true)
  const [showElements, setShowElements] = React.useState(true)
  const [title, settitle] = useState([])
  const [newPatient, setnewPatient] = useState({
    title: '',
    firstName: '',
    lastName: '',
    address: '',
    dob: '',
    nic: '',
    mStat: '',
    nationality: '',
    religion: '',
    gender: '',
    phone: '',
    email: ''

  })

  useEffect(() => {
    getTitles()
  }, [])

  const getTitles = async () => {
    axios.get('http://localhost:8081/api/title').then(e => settitle(e.data));

  }

  const handleSubmit = async (e) => {
    e.preventDefault()
    const data = JSON.stringify(newPatient)
    const res = await axios.post('http://localhost:8081/api/patient', data, {
      headers: {
        'Content-Type': 'application/json'
      }
    })
    console.log(res)
  }



  const handleChange = (e) => {
    const data = { ...newPatient }
    data[e.id] = e.val
    setnewPatient({
      ...data
    })
    console.log(newPatient)
  }

  return (
    <>

      <CCard >
        <CCardHeader>
          Patient Registration
        </CCardHeader>
        <CCardBody>
          <CForm action="" method="post" className="form-horizontal">
            <CFormGroup row>
              <CCol md="3">
                <CLabel htmlFor="select">Title</CLabel>
              </CCol>
              <CCol xs="12" md="9">
                <CSelect custom name="title" id="title" onChange={e => handleChange({ val: e.target.value, id: e.target.id })}>
                  {title.map((tit, i) => {
                    return (<option value={tit.id} key={tit.id}>{tit.name}</option>)
                  })}
                </CSelect>
              </CCol>
            </CFormGroup>
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
                <CLabel htmlFor="mStat">Maritial Stat</CLabel>
              </CCol>
              <CCol xs="12" md="9">
                <CSelect custom name="mStat" id="mStat" onChange={e => handleChange({ val: e.target.value, id: e.target.id })}>
                  <option value="0">Please select</option>
                  <option value="1">Option #1</option>
                  <option value="2">Option #2</option>
                  <option value="3">Option #3</option>
                </CSelect>
              </CCol>
            </CFormGroup>
            <CFormGroup row>
              <CCol md="3">
                <CLabel htmlFor="nationality">Nationality</CLabel>
              </CCol>
              <CCol xs="12" md="9">
                <CInput id="nationality" name="nationality" placeholder="Enter Nationality" onChange={e => handleChange({ val: e.target.value, id: e.target.id })} />
              </CCol>
            </CFormGroup>
            <CFormGroup row>
              <CCol md="3">
                <CLabel htmlFor="religion">religion</CLabel>
              </CCol>
              <CCol xs="12" md="9">
                <CInput id="religion" name="religion" placeholder="Enter Religion" onChange={e => handleChange({ val: e.target.value, id: e.target.id })} />
              </CCol>
            </CFormGroup>

            <CFormGroup row>
              <CCol md="3">
                <CLabel htmlFor="gender">Gender</CLabel>
              </CCol>
              <CCol xs="12" md="9">
                <CSelect custom name="gender" id="gender" onChange={e => handleChange({ val: e.target.value, id: e.target.id })}>
                  <option value="0">Please select</option>
                  <option value="1">Option #1</option>
                  <option value="2">Option #2</option>
                  <option value="3">Option #3</option>
                </CSelect>
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

export default CreatePatient
