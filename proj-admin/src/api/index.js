
import {get, post} from './requests'

const API = {
  getUsers: () => get('users'),
  // eslint-disable-next-line no-template-curly-in-string
  deleteUser: (id) => get(`users/delete?id=${id}`),
  setUser: (params) => post(`users/add`, params),
  editUser: (params) => post(`users/edit`, params),

  getCourses: () => get(`courses`),
  deleteCourse: (id) => get(`courses/delete?id=${id}`),
  addCourse: (params) => post(`courses/add`, params),
  editCourse: (params) => post(`courses/edit`, params),

  getProfs: () => get(`profs`),
  deleteProf: (id) => get(`profs/delete?id=${id}`),
  addProf: (params) => post(`profs/add`, params),
  editProf: (params) => post(`profs/edit`, params),

  getCourseEvals: () => get(`courseevals`),
  deleteCourseEval: (id) => get(`courseevals/delete?id=${id}`),
  addCourseEval: (params) => post(`courseevals/add`, params),
  editCourseEval: (params) => post(`courseevals/edit`, params),

  getProfEvals: () => get(`profevals`),
  deleteProfEval: (id) => get(`profevals/delete?id=${id}`),
  addProfEval: (params) => post(`profevals/add`, params),
  editProfEval: (params) => post(`profevals/edit`, params)

}

export { API }
