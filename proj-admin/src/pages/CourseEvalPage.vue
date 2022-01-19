<template>
<div>
  <h1>Course Evaluations</h1>
  <div>
    <el-button style="float: left" type="primary" size="mini" @click="addDataVisible = true">Add New Course Evaluation</el-button>
  </div>

<el-table
    :data="tableData"
    border
    style="width: 100%">
    <template slot="empty">
      <span style="color: #969799;">No data. Please make sure the backend server is running.</span>
    </template>
    <el-table-column
      prop="user"
      label="User Name"
      width="200"
      align="center">
    </el-table-column>
    <el-table-column
      prop="coursenumber"
      label="Course Number"
      width="180"
      align="center">
    </el-table-column>
    <el-table-column
      prop="profname"
      label="Professor"
      width="200"
      align="center">
    </el-table-column>
    <el-table-column
      prop="semester"
      label="Semester"
      width="180"
      align="center">
    </el-table-column>
    <el-table-column
      prop="rating"
      label="Course Rating"
      width="180"
      align="center">
    </el-table-column>
    <el-table-column
      prop="comment"
      label="Course Evaluation"
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
  <el-dialog title="Add Course Evaluation" :visible.sync="addDataVisible" width="400px" center>
    <el-form :model="addForm" status-icon ref="form" label-width="120px" class="demo-ruleForm">
      <el-form-item label="User Name" prop="user" size="mini">
        <el-input placeholder="User name who made this comment" v-model="addForm.user"></el-input>
      </el-form-item>
      <el-form-item label="Course Number" prop="coursenumber" size="mini">
        <el-input type="number" v-model="addForm.coursenumber" placeholder="5 digit course number (e.g., 15112)"></el-input>
      </el-form-item>
      <el-form-item label="Professor Name" prop="profname" size="mini">
        <el-input placeholder="Professor name" v-model="addForm.profname"></el-input>
      </el-form-item>
      <el-form-item label="Semester" prop="semester" size="mini">
        <el-input v-model="addForm.semester" placeholder="the semester of this course (e.g. S20, F19, U21...)"></el-input>
      </el-form-item>
      <el-form-item label="Course Rating" prop="rating" size="mini">
        <el-input type="number" v-model="addForm.rating" placeholder="rating of the course, an integer from 1 to 5"></el-input>
      </el-form-item>
      <el-form-item label="Course Evaluation" prop="comment" size="mini">
        <el-input placeholder="Evaluation for the course" v-model="addForm.comment"></el-input>
      </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button size="mini" @click="addDataVisible = false">Cancel</el-button>
      <el-button type="primary" size="mini" @click="addData">Confirm</el-button>
    </span>
  </el-dialog>

  <!-- editing data pop-out form -->
  <el-dialog title="Edit Course Evaluation" :visible.sync="editDataVisible" width="400px" center>
    <el-form :model="editForm" status-icon ref="form" label-width="120px" class="demo-ruleForm">
      <el-form-item label="User Name" prop="user" size="mini">
        <el-input v-model="editForm.user" :disabled=true></el-input>
      </el-form-item>
      <el-form-item label="Course Number" prop="coursenumber" size="mini">
        <el-input type="number" v-model="editForm.coursenumber" :disabled=true></el-input>
      </el-form-item>
      <el-form-item label="Professor Name" prop="profname" size="mini">
        <el-input v-model="editForm.profname"></el-input>
      </el-form-item>
      <el-form-item label="Semester" prop="semester" size="mini">
        <el-input v-model="editForm.semester"></el-input>
      </el-form-item>
      <el-form-item label="Course Rating" prop="rating" size="mini">
        <el-input type="number" v-model="editForm.rating"></el-input>
      </el-form-item>
      <el-form-item label="Course Evaluation" prop="comment" size="mini">
        <el-input v-model="editForm.comment"></el-input>
      </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button size="mini" @click="editDataVisible = false">Cancel</el-button>
      <el-button type="primary" size="mini" @click="editData">Confirm</el-button>
    </span>
  </el-dialog>

  <!-- deleting data confirm pop-out  -->
  <el-dialog title="Notice" :visible.sync="delVisible" width="300px" center>
    <div class="del-dialog-cnt" align="center">This operation cannot be undone. <br/> Sure to delete this course evaluation?</div>
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
        user: '',
        coursenumber: null,
        profname: '',
        semester: '',
        rating: null,
        comment: ''
      },
      editForm: {
        id: '',
        user: '',
        coursenumber: null,
        profname: '',
        semester: '',
        rating: null,
        comment: ''
      }
    }
  },
  created () {
    this.getData()
  },
  methods: {
    getData () {
      this.tableData = []
      API.getCourseEvals()
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
      API.deleteCourseEval(this.deleteID).then((res) => {
        if (res) {
          this.getData()
          this.$notify({
            title: 'Deleting Course Evaluation Succeed.',
            type: 'success'
          })
        } else {
          this.$notify({
            title: 'Deleting Course Evaluation Failed',
            type: 'error'
          })
        }
      }).catch((err) => {
        console.log(err)
      })
    },
    handleEdit (row) {
      this.editForm.id = row.id
      this.editForm.user = row.user
      this.editForm.coursenumber = row.coursenumber
      this.editForm.profname = row.profname
      this.editForm.semester = row.semester
      this.editForm.rating = row.rating
      this.editForm.comment = row.comment

      this.editDataVisible = true
    },
    editData () {
      this.editDataVisible = false
      let params = new URLSearchParams()
      params.append('id', this.editForm.id) // need to pass in id
      params.append('user', this.editForm.user)
      params.append('coursenumber', this.editForm.coursenumber)
      params.append('profname', this.editForm.profname)
      params.append('semester', this.editForm.semester)
      params.append('rating', this.editForm.rating)
      params.append('comment', this.editForm.comment)
      API.editCourseEval(params)
        .then(res => {
          if (res) {
            this.getData()
            this.addForm = {}
            this.$notify({
              title: 'Editing Course Evaluation Succeed.',
              type: 'success'
            })
          } else {
            this.$notify({
              title: 'Editing Course Evaluation Failed.',
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
      params.append('user', this.addForm.user)
      params.append('coursenumber', this.addForm.coursenumber)
      params.append('profname', this.addForm.profname)
      params.append('semester', this.addForm.semester)
      params.append('rating', this.addForm.rating)
      params.append('comment', this.addForm.comment)
      API.addCourseEval(params)
        .then(res => {
          if (res) {
            this.getData()
            this.addForm = {}
            this.$notify({
              title: 'Adding Course Evaluation Succeed.',
              type: 'success'
            })
          } else {
            this.$notify({
              title: 'Adding Course Evaluation Failed.',
              type: 'error'
            })
          }
        })
        .catch(err => {
          console.log(err)
          this.$notify({
            title: 'Adding Course Evaluation Failed.',
            type: 'error'
          })
        })
    }
  }
}
</script>

<style>

</style>
