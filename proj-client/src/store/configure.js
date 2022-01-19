const configure = {
  state: {
    login: false // 用户是否登录
  },
  getters: {
    login: state => {
      let login = state.login
      if (!login) {
        login = JSON.parse(window.sessionStorage.getItem('login') || null)
      }
      return login
    }
  },
  mutations: {
    setLogin: (state, login) => {
      state.login = login
      window.sessionStorage.setItem('login', JSON.stringify(login))
    }
  },
  actions: {}
}

export default configure
