<template>
<div>
  <h1>Users</h1>
  <div>
    <el-button style="float: left" type="primary" size="mini" @click="addUserVisible = true">Add New User</el-button>
  </div>

<el-table
    :data="tableData"
    border
    style="width: 100%">
    <template slot="empty">
      <span style="color: #969799;">No data. Please make sure the backend server is running.</span>
    </template>
    <el-table-column
      prop="username"
      label="Username"
      width="160"
      align="center">
    </el-table-column>
    <el-table-column
      prop="password"
      label="Password"
      width="160"
      align="center">
    </el-table-column>
    <el-table-column
      prop="email"
      label="Email"
      width="160"
      align="center">
    </el-table-column>
    <el-table-column
      prop="college"
      label="College"
      width="80"
      align="center">
    </el-table-column>
    <el-table-column
      prop="gradYear"
      label="Graduation Year"
      width="140"
      align="center">
    </el-table-column>
    <el-table-column label="operations" width="180" align="center">
      <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.row)">Edit</el-button>
          <el-button size="mini" type="danger" @click="handleDelete(scope.row.id)">Remove</el-button>
      </template>
    </el-table-column>
  </el-table>

  <!-- adding user pop-out form -->
  <el-dialog title="Add User" :visible.sync="addUserVisible" width="400px" center>
    <el-form :model="userForm" status-icon ref="form" label-width="110px" class="demo-ruleForm">
      <el-form-item label="User Name" prop="username" size="mini">
        <el-input v-model="userForm.username" placeholder="user name"></el-input>
      </el-form-item>
      <el-form-item label="Password" prop="password" size="mini">
        <el-input type="password" placeholder="password" v-model="userForm.password"></el-input>
      </el-form-item>
      <el-form-item label="College" prop="college" size="mini">
        <el-input v-model="userForm.college" placeholder="CIT / MCS / SCS / DC / ..."></el-input>
      </el-form-item>
      <el-form-item label="Email" prop="email" size="mini">
        <el-input v-model="userForm.email" placeholder="andrew-id@andrew.cmu.edu / email@example.com"></el-input>
      </el-form-item>
      <el-form-item label="Graduation Year" prop="gradYear" size="mini">
        <el-input type="number" placeholder="2022 / 2023 / 2024 / ..." v-model="userForm.gradYear"></el-input>
      </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button size="mini" @click="addUserVisible = false">Cancel</el-button>
      <el-button type="primary" size="mini" @click="addUser">Confirm</el-button>
    </span>
  </el-dialog>

  <!-- editing user pop-out form -->
  <el-dialog title="Edit User" :visible.sync="editUserVisible" width="400px" center>
    <el-form :model="editForm" status-icon ref="form" label-width="110px" class="demo-ruleForm">
      <el-form-item label="User Name" prop="username" size="mini">
        <el-input v-model="editForm.username" :disabled=true></el-input>
      </el-form-item>
      <el-form-item label="Password" prop="password" size="mini">
        <el-input type="password" v-model="editForm.password"></el-input>
      </el-form-item>
      <el-form-item label="College" prop="college" size="mini">
        <el-input v-model="editForm.college" ></el-input>
      </el-form-item>
      <el-form-item label="Email" prop="email" size="mini">
        <el-input v-model="editForm.email" ></el-input>
      </el-form-item>
      <el-form-item label="Graduation Year" prop="gradYear" size="mini">
        <el-input type="number" v-model="editForm.gradYear"></el-input>
      </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button size="mini" @click="editUserVisible = false">Cancel</el-button>
      <el-button type="primary" size="mini" @click="editUser">Confirm</el-button>
    </span>
  </el-dialog>

  <!-- deleting user confirm pop-out  -->
  <el-dialog title="Notice" :visible.sync="delVisible" width="300px" center>
    <div class="del-dialog-cnt" align="center">This operation cannot be undone. <br/> Sure to delete user?</div>
    <span slot="footer" class="dialog-footer">
      <el-button size="mini" @click="delVisible = false">Cancel</el-button>
      <el-button size="mini" type="danger" @click="deleteUser">Delete</el-button>
    </span>
  </el-dialog>
</div>

</template>

<script>
import { API } from '../api/index'

export default {
  data () {
    return {
      delVisible: false, // delete warning tag
      deleteID: null, // delete user ID
      addUserVisible: false,
      editUserVisible: false,
      tableData: [],
      userForm: {
        username: '',
        password: '',
        college: '',
        email: '',
        gradYear: null
      },
      editForm: {
        id: '',
        username: '',
        password: '',
        college: '',
        email: '',
        gradYear: null
      }
    }
  },
  created () {
    this.getData()
  },
  methods: {
    getData () {
      this.tableData = []
      API.getUsers().then((res) => {
        this.tableData = res
      })
    },
    handleDelete (id) {
      this.deleteID = id
      this.delVisible = true
    },
    deleteUser () {
      this.delVisible = false
      API.deleteUser(this.deleteID).then((res) => {
        if (res) {
          this.getData()
          this.$notify({
            title: 'Deleting User Succeed.',
            type: 'success'
          })
        } else {
          this.$notify({
            title: 'Deleting User Failed',
            type: 'error'
          })
        }
      }).catch((err) => {
        console.log(err)
      })
    },
    handleEdit (row) {
      this.editForm.id = row.id
      this.editForm.username = row.username
      this.editForm.password = row.password
      this.editForm.college = row.college
      this.editForm.email = row.email
      this.editForm.gradYear = row.gradYear

      this.editUserVisible = true
    },
    editUser () {
      this.editUserVisible = false
      let params = new URLSearchParams()
      params.append('id', this.editForm.id) // need to pass in id
      params.append('username', this.editForm.username)
      params.append('password', this.editForm.password)
      params.append('college', this.editForm.college)
      params.append('email', this.editForm.email)
      params.append('gradYear', this.editForm.gradYear)
      API.editUser(params)
        .then(res => {
          if (res) {
            this.getData()
            this.userForm = {}
            this.$notify({
              title: 'Editing User Succeed.',
              type: 'success'
            })
          } else {
            this.$notify({
              title: 'Editing User Failed.',
              type: 'error'
            })
          }
        })
        .catch(err => {
          console.log(err)
        })
    },
    addUser () {
      this.addUserVisible = false
      let params = new URLSearchParams()
      params.append('username', this.userForm.username)
      params.append('password', this.userForm.password)
      params.append('college', this.userForm.college)
      params.append('email', this.userForm.email)
      params.append('gradYear', this.userForm.gradYear)
      API.setUser(params)
        .then(res => {
          if (res) {
            this.getData()
            this.userForm = {}
            this.$notify({
              title: 'Adding User Succeed.',
              type: 'success'
            })
          } else {
            this.$notify({
              title: 'Adding User Failed.',
              type: 'error'
            })
          }
        })
        .catch(err => {
          console.log(err)
        })
    }
  }
}
</script>

<style>

</style>
