<template>
<div>
  <h1>Courses</h1>
  <div>
    <el-button style="float: left" type="primary" size="mini" @click="addDataVisible = true">Add New Course</el-button>
  </div>

<el-table
    :data="tableData"
    border
    style="width: 100%">
    <template slot="empty">
      <span style="color: #969799;">No data. Please make sure the backend server is running.</span>
    </template>
    <el-table-column
      prop="number"
      label="Course Number"
      width="180"
      align="center">
    </el-table-column>
    <el-table-column
      prop="name"
      label="Course Name"
      width="200"
      align="center">
    </el-table-column>
    <el-table-column
      prop="units"
      label="Units"
      width="60"
      align="center">
    </el-table-column>
    <el-table-column
      prop="prof"
      label="Professor"
      width="180"
      align="center">
    </el-table-column>
    <el-table-column
      prop="intro"
      label="Course Introduction"
      width="300"
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
  <el-dialog title="Add Course" :visible.sync="addDataVisible" width="400px" center>
    <el-form :model="addForm" status-icon ref="form" label-width="110px" class="demo-ruleForm">
      <el-form-item label="Course Number" prop="number" size="mini">
        <el-input type="number" v-model="addForm.number" placeholder="5 digit course number (e.g., 15112)"></el-input>
      </el-form-item>
      <el-form-item label="Course Name" prop="name" size="mini">
        <el-input placeholder="course name" v-model="addForm.name"></el-input>
      </el-form-item>
      <el-form-item label="Units" prop="units" size="mini">
        <el-input type="number" v-model="addForm.units" placeholder="units of the course (e.g., 12)"></el-input>
      </el-form-item>
      <el-form-item label="Professor" prop="prof" size="mini">
        <el-input v-model="addForm.prof" placeholder="name of professor teaching this course"></el-input>
      </el-form-item>
      <el-form-item label="Introduction" prop="intro" size="mini">
        <el-input placeholder="Introduction for the course" v-model="addForm.intro"></el-input>
      </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button size="mini" @click="addDataVisible = false">Cancel</el-button>
      <el-button type="primary" size="mini" @click="addData">Confirm</el-button>
    </span>
  </el-dialog>

  <!-- editing data pop-out form -->
  <el-dialog title="Edit Course" :visible.sync="editDataVisible" width="400px" center>
    <el-form :model="editForm" status-icon ref="form" label-width="110px" class="demo-ruleForm">
      <el-form-item label="Course Number" prop="number" size="mini">
        <el-input type="number" v-model="editForm.number" :disabled=true></el-input>
      </el-form-item>
      <el-form-item label="Course Name" prop="name" size="mini">
        <el-input laceholder="course name" v-model="editForm.name"></el-input>
      </el-form-item>
      <el-form-item label="Units" prop="units" size="mini">
        <el-input type="number" v-model="editForm.units" ></el-input>
      </el-form-item>
      <el-form-item label="Professor" prop="prof" size="mini">
        <el-input v-model="editForm.prof"></el-input>
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
    <div class="del-dialog-cnt" align="center">This operation cannot be undone. <br/> Sure to delete course?</div>
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
        number: null,
        prof: '',
        units: null,
        intro: ''
      },
      editForm: {
        id: '',
        name: '',
        number: null,
        prof: '',
        units: null,
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
      API.getCourses()
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
      API.deleteCourse(this.deleteID).then((res) => {
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
      this.editForm.prof = row.prof
      this.editForm.number = row.number
      this.editForm.intro = row.intro
      this.editForm.units = row.units

      this.editDataVisible = true
    },
    editData () {
      this.editDataVisible = false
      let params = new URLSearchParams()
      params.append('id', this.editForm.id) // need to pass in id
      params.append('name', this.editForm.name)
      params.append('prof', this.editForm.prof)
      params.append('number', this.editForm.number)
      params.append('intro', this.editForm.intro)
      params.append('units', this.editForm.units)
      API.editCourse(params)
        .then(res => {
          if (res) {
            this.getData()
            this.addForm = {}
            this.$notify({
              title: 'Editing Course Succeed.',
              type: 'success'
            })
          } else {
            this.$notify({
              title: 'Editing Course Failed.',
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
      params.append('prof', this.addForm.prof)
      params.append('number', this.addForm.number)
      params.append('intro', this.addForm.intro)
      params.append('units', this.addForm.units)
      API.addCourse(params)
        .then(res => {
          if (res) {
            this.getData()
            this.addForm = {}
            this.$notify({
              title: 'Adding Course Succeed.',
              type: 'success'
            })
          } else {
            this.$notify({
              title: 'Adding Course Failed.',
              type: 'error'
            })
          }
        })
        .catch(err => {
          console.log(err)
          this.$notify({
            title: 'Adding Course Failed.',
            type: 'error'
          })
        })
    }
  }
}
</script>

<style>

</style>
