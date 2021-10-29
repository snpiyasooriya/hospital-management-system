import React, { useState, useEffect } from 'react'
import {
    CCard,
    CCardBody,
    CCardHeader,
    CDataTable,

} from '@coreui/react'
import { DocsLink } from 'src/reusable'

import usersData from '../users/UsersData'
import axios from 'axios'

const getBadge = status => {
    switch (status) {
        case 1: return 'success'
        case 0: return 'warning'
        default: return 'primary'
    }
}
const fields = ['id', 'firstName', 'lastName', 'dob', 'nic', 'location']

const Doctor = () => {
    const [doctor, setDoctor] = useState([])

    const getDoctors = async () => {
        const res = await axios.get("http://localhost:8081/api/doctor");

        setDoctor(res.data)
    }

    const scopedSlots = {

        'location': (item) => (
            <td>
                {item.location.name}

            </td>
        ),

    }

    useEffect(() => {
        getDoctors()
    }, [])
    console.log(doctor)

    return (
        <>

            <CCard>
                <CCardHeader>
                    Doctor
                </CCardHeader>
                <CCardBody>
                    <CDataTable
                        items={doctor}
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

        </>
    )
}

export default Doctor
