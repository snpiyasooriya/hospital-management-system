import React from 'react'
import CIcon from '@coreui/icons-react'

const _nav = [

  {
    _tag: 'CSidebarNavTitle',
    _children: ['Management']
  },
  {
    _tag: 'CSidebarNavDropdown',
    name: 'Patient',
    route: '/patient',
    icon: 'cil-puzzle',
    _children: [
      {
        _tag: 'CSidebarNavItem',
        name: 'Register Patient',
        to: '/patient/create',
      },
      {
        _tag: 'CSidebarNavItem',
        name: 'View Patient',
        to: '/patient',
      },
      {
        _tag: 'CSidebarNavItem',
        name: 'Patient Admit',
        to: '/patient/admit',
      },
      {
        _tag: 'CSidebarNavItem',
        name: 'Patient Transfer',
        to: '/patient/transfer',
      },

    ],
  },
  {
    _tag: 'CSidebarNavDropdown',
    name: 'Doctor',
    route: '/doctor',
    icon: 'cil-puzzle',
    _children: [
      {
        _tag: 'CSidebarNavItem',
        name: 'Register Doctor',
        to: '/doctor/register',
      },
      {
        _tag: 'CSidebarNavItem',
        name: 'View Doctor',
        to: '/doctor',
      },

    ],
  },

  {
    _tag: 'CSidebarNavTitle',
    _children: ['Master Data']
  },
  {
    _tag: 'CSidebarNavDropdown',
    name: 'User Master',
    route: '/user',
    icon: 'cil-puzzle',
    _children: [
      {
        _tag: 'CSidebarNavItem',
        name: 'Register User',
        to: '/user/register',
      },
      {
        _tag: 'CSidebarNavItem',
        name: 'View User',
        to: '/user',
      },

    ],
  },



]

export default _nav
