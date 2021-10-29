import React, { useState, useEffect } from 'react'
import {
    CCard,
    CCardBody,
    CCardHeader,
    CDataTable,

} from '@coreui/react'
import { DocsLink } from 'src/reusable'
import axios from 'axios'

const getBadge = status => {
    switch (status) {
        case 1: return 'success'
        case 0: return 'warning'
        default: return 'primary'
    }
}
const fields = ['id', 'firstName', 'lastName', 'dob', 'nic','email','phone','address', 'location', 'type']

const User = () => {
    const [user, setUser] = useState([])

    const getUsers = async () => {
        const res = await axios.get("http://localhost:8081/api/user");

        setUser(res.data)
    }

    const scopedSlots = {

        'location': (item) => (
            <td>
                {item.location.name}

            </td>
        ),
        'type':(item)=>(
            <td>
            {item.type.type}

        </td>
        )

    }

    useEffect(() => {
        getUsers()
    }, [])
    console.log(user)

    return (
        <>

            <CCard>
                <CCardHeader>
                    View User
                </CCardHeader>
                <CCardBody>
                    <CDataTable
                        items={user}
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

export default User
