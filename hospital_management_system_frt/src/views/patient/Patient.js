import React, { useState, useEffect } from 'react'
import {
    CBadge,
    CCard,
    CCardBody,
    CCardHeader,
    CCol,
    CDataTable,
    CRow
} from '@coreui/react'
import { DocsLink } from 'src/reusable'

import usersData from '../users/UsersData'
import axios from 'axios'

const getBadge = status => {
    switch (status) {
        case 'Active': return 'success'
        case 'Inactive': return 'secondary'
        case 'Pending': return 'warning'
        case 'Banned': return 'danger'
        default: return 'primary'
    }
}
const fields = [ 'id','title','firstName', 'lastName', 'dob', 'nationality', 'nic']

const Patient = () => {
    const [patients, setpatients] = useState([])

    const getPatients = async () => {
        const res = await axios.get("http://localhost:8081/api/patient");
       
        setpatients(res.data)
    }

    useEffect(() => {
        getPatients()
    }, [])
    console.log(patients)

    return (
        <>

            <CCard>
                <CCardHeader>
                    Patients
                </CCardHeader>
                <CCardBody>
                    <CDataTable
                        items={patients}
                        fields={fields}
                        hover
                        striped
                        bordered
                        size="sm"
                        itemsPerPage={10}
                        pagination
                        sorter
                        tableFilter
                         scopedSlots = {{
                'title':
                  (item)=>(
                    <td>
                      
                        {item.title.name}
                    
                    </td>
                  )

              }}

                            
                        
                    />
                </CCardBody>
            </CCard>

        </>
    )
}

export default Patient
