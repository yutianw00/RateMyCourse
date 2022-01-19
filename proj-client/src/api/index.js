
import {get, post} from './requests'

const API = {
  addUser: (params) => post(`users/add`, params),
  userLogin: (params) => post(`users/login`, params),
  //   getUsers: () => get('users'),
  //   // eslint-disable-next-line no-template-curly-in-string
  //   deleteUser: (id) => get(`users/delete?id=${id}`),
  //   editUser: (params) => post(`users/edit`, params),

  getCourses: () => get(`courses`),
  //   deleteCourse: (id) => get(`courses/delete?id=${id}`),
  //   addCourse: (params) => post(`courses/add`, params),
  //   editCourse: (params) => post(`courses/edit`, params),

  getProfs: () => get(`profs`),
  //   deleteProf: (id) => get(`profs/delete?id=${id}`),
  //   addProf: (params) => post(`profs/add`, params),
  //   editProf: (params) => post(`profs/edit`, params)

  getCourseEvals: () => get(`courseevals`),
  getCourseEvalsByUser: (user) => get(`courseevals/user?user=${user}`),
  addCourseEval: (params) => post(`courseevals/add`, params),

  getProfEvals: () => get(`profevals`),
  getProfEvalsByUser: (user) => get(`profevals/user?user=${user}`),
  addProfEval: (params) => post(`profevals/add`, params)
}

export { API }
