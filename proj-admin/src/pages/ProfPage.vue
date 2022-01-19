<template>
  <div>
  <h1>Professors</h1>
  <div>
    <el-button style="float: left" type="primary" size="mini" @click="addDataVisible = true">Add New Professor</el-button>
  </div>

<el-table
    :data="tableData"
    border
    style="width: 100%">
    <template slot="empty">
      <span style="color: #969799;">No data. Please make sure the backend server is running.</span>
    </template>
    <el-table-column
      prop="name"
      label="Professor Name"
      width="200"
      align="center">
    </el-table-column>
    <el-table-column
      prop="rating"
      label="Rating"
      width="100"
      align="center">
    </el-table-column>
    <el-table-column
      prop="intro"
      label="Professor Introduction"
      width="800"
      align="center">
    </el-table-column>
    <el-table-column label="operations" width="180" align="center">
      <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.row)">Edit</el-button>
          <el-button size="mini" type="danger" @click="handleDelete(scope.row.id)">Remove</el-button>
      </template>
    </el-table-column>
  </el-table>

  <!-- adding data pop-out form -->
  <el-dialog title="Add Professor" :visible.sync="addDataVisible" width="400px" center>
    <el-form :model="addForm" status-icon ref="form" label-width="110px" class="demo-ruleForm">
      <el-form-item label="Professor Name" prop="name" size="mini">
        <el-input laceholder="course name" v-model="addForm.name"></el-input>
      </el-form-item>
      <el-form-item label="Rating" prop="rating" size="mini">
        <el-input type="number" v-model="addForm.rating" placeholder="rating for the professor (from 1 to 5)"></el-input>
      </el-form-item>
      <el-form-item label="Introduction" prop="intro" size="mini">
        <el-input placeholder="Introduction for the professor" v-model="addForm.intro"></el-input>
      </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button size="mini" @click="addDataVisible = false">Cancel</el-button>
      <el-button type="primary" size="mini" @click="addData">Confirm</el-button>
    </span>
  </el-dialog>

  <!-- editing data pop-out form -->
  <el-dialog title="Add Course" :visible.sync="editDataVisible" width="400px" center>
    <el-form :model="editForm" status-icon ref="form" label-width="110px" class="demo-ruleForm">
      <el-form-item label="Professor Name" prop="name" size="mini">
        <el-input v-model="editForm.name" :disabled=true></el-input>
      </el-form-item>
      <el-form-item label="Rating" prop="rating" size="mini">
        <el-input type="number" v-model="editForm.rating"></el-input>
      </el-form-item>
      <el-form-item label="Introduction" prop="intro" size="mini">
        <el-input v-model="editForm.intro"></el-input>
      </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button size="mini" @click="editDataVisible = false">Cancel</el-button>
      <el-button type="primary" size="mini" @click="editData">Confirm</el-button>
    </span>
  </el-dialog>

  <!-- deleting data confirm pop-out  -->
  <el-dialog title="Notice" :visible.sync="delVisible" width="300px" center>
    <div class="del-dialog-cnt" align="center">This operation cannot be undone. <br/> Sure to delete this professor info from the database?</div>
    <span slot="footer" class="dialog-footer">
      <el-button size="mini" @click="delVisible = false">Cancel</el-button>
      <el-button size="mini" type="danger" @click="deleteData">Delete</el-button>
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
      deleteID: null, // delete data ID
      addDataVisible: false,
      editDataVisible: false,
      tableData: [],
      addForm: {
        name: '',
        rating: null,
        intro: ''
      },
      editForm: {
        id: null,
        name: '',
        rating: null,
        intro: ''
      }
    }
  },
  created () {
    this.getData()
  },
  methods: {
    getData () {
      this.tableData = []
      API.getProfs()
        .then((res) => {
          this.tableData = res
        }).catch((err) => {
          console.log(err)
        })
    },
    handleDelete (id) {
      this.deleteID = id
      this.delVisible = true
    },
    deleteData () {
      this.delVisible = false
      API.deleteProf(this.deleteID).then((res) => {
        if (res) {
          this.getData()
          this.$notify({
            title: 'Deleting Course Succeed.',
            type: 'success'
          })
        } else {
          this.$notify({
            title: 'Deleting Course Failed',
            type: 'error'
          })
        }
      }).catch((err) => {
        console.log(err)
      })
    },
    handleEdit (row) {
      this.editForm.id = row.id
      this.editForm.name = row.name
      this.editForm.rating = row.rating
      this.editForm.intro = row.intro

      this.editDataVisible = true
    },
    editData () {
      this.editDataVisible = false
      let params = new URLSearchParams()
      params.append('id', this.editForm.id) // need to pass in id
      params.append('name', this.editForm.name)
      params.append('rating', this.editForm.rating)
      params.append('intro', this.editForm.intro)
      API.editProf(params)
        .then(res => {
          if (res) {
            this.getData()
            this.addForm = {}
            this.$notify({
              title: 'Editing Professor Info Succeed.',
              type: 'success'
            })
          } else {
            this.$notify({
              title: 'Editing Professor Info Failed.',
              type: 'error'
            })
          }
        })
        .catch(err => {
          console.log(err)
        })
    },
    addData () {
      this.addDataVisible = false
      let params = new URLSearchParams()
      params.append('name', this.addForm.name)
      params.append('rating', this.addForm.rating)
      params.append('intro', this.addForm.intro)

      API.addProf(params)
        .then(res => {
          if (res) {
            this.getData()
            this.addForm = {}
            this.$notify({
              title: 'Adding Professor Info Succeed.',
              type: 'success'
            })
          } else {
            this.$notify({
              title: 'Adding Professor Info Failed.',
              type: 'error'
            })
          }
        })
        .catch(err => {
          console.log(err)
          this.$notify({
            title: 'Adding Professor Info Failed.',
            type: 'error'
          })
        })
    }
  }
}
</script>

<style>

</style>
