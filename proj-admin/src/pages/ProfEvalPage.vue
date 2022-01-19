<template>
<div>
  <h1>Professor Evaluations</h1>
  <div>
    <el-button style="float: left" type="primary" size="mini" @click="addDataVisible = true">Add New Professor Evaluation</el-button>
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
      prop="profname"
      label="Professor Name"
      width="200"
      align="center">
    </el-table-column>
    <el-table-column
      prop="rating"
      label="Professor Rating"
      width="180"
      align="center">
    </el-table-column>
    <el-table-column
      prop="comment"
      label="Professor Evaluation"
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
  <el-dialog title="Add Professor Evaluation" :visible.sync="addDataVisible" width="400px" center>
    <el-form :model="addForm" status-icon ref="form" label-width="150px" class="demo-ruleForm">
      <el-form-item label="User Name" prop="user" size="mini">
        <el-input placeholder="username who made the comment" v-model="addForm.user"></el-input>
      </el-form-item>
      <el-form-item label="Professor Name" prop="profname" size="mini">
        <el-input placeholder="Professor name" v-model="addForm.profname"></el-input>
      </el-form-item>
      <el-form-item label="Professor Rating" prop="rating" size="mini">
        <el-input type="number" v-model="addForm.rating" placeholder="rating of the professor, an integer from 1 to 5"></el-input>
      </el-form-item>
      <el-form-item label="Professor Evaluation" prop="comment" size="mini">
        <el-input placeholder="Evaluation for the professor" v-model="addForm.comment"></el-input>
      </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button size="mini" @click="addDataVisible = false">Cancel</el-button>
      <el-button type="primary" size="mini" @click="addData">Confirm</el-button>
    </span>
  </el-dialog>

  <!-- editing data pop-out form -->
  <el-dialog title="Edit Professor Evaluation" :visible.sync="editDataVisible" width="400px" center>
    <el-form :model="editForm" status-icon ref="form" label-width="150px" class="demo-ruleForm">
      <el-form-item label="User Name" prop="profname" size="mini">
        <el-input v-model="editForm.user" :disabled=true></el-input>
      </el-form-item>
      <el-form-item label="Professor Name" prop="profname" size="mini">
        <el-input v-model="editForm.profname" :disabled=true></el-input>
      </el-form-item>
      <el-form-item label="Professor Rating" prop="rating" size="mini">
        <el-input type="number" v-model="editForm.rating"></el-input>
      </el-form-item>
      <el-form-item label="Professor Evaluation" prop="comment" size="mini">
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
    <div class="del-dialog-cnt" align="center">This operation cannot be undone. <br/> Sure to delete this professor evaluation?</div>
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
        profname: '',
        rating: null,
        comment: ''
      },
      editForm: {
        id: '',
        user: '',
        profname: '',
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
      API.getProfEvals()
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
      API.deleteProfEval(this.deleteID).then((res) => {
        if (res) {
          this.getData()
          this.$notify({
            title: 'Deleting Professor Evaluation Succeed.',
            type: 'success'
          })
        } else {
          this.$notify({
            title: 'Deleting Professor Evaluation Failed',
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
      this.editForm.profname = row.profname
      this.editForm.rating = row.rating
      this.editForm.comment = row.comment

      this.editDataVisible = true
    },
    editData () {
      this.editDataVisible = false
      let params = new URLSearchParams()
      params.append('id', this.editForm.id) // need to pass in id
      params.append('user', this.editForm.user)
      params.append('profname', this.editForm.profname)
      params.append('rating', this.editForm.rating)
      params.append('comment', this.editForm.comment)
      API.editProfEval(params)
        .then(res => {
          if (res) {
            this.getData()
            this.addForm = {}
            this.$notify({
              title: 'Editing Professor Evaluation Succeed.',
              type: 'success'
            })
          } else {
            this.$notify({
              title: 'Editing Professor Evaluation Failed.',
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
      params.append('profname', this.addForm.profname)
      params.append('user', this.addForm.user)
      params.append('rating', this.addForm.rating)
      params.append('comment', this.addForm.comment)
      API.addProfEval(params)
        .then(res => {
          if (res) {
            this.getData()
            this.addForm = {}
            this.$notify({
              title: 'Adding Professor Evaluation Succeed.',
              type: 'success'
            })
          } else {
            this.$notify({
              title: 'Adding Professor Evaluation Failed.',
              type: 'error'
            })
          }
        })
        .catch(err => {
          console.log(err)
          this.$notify({
            title: 'Adding Professor Evaluation Failed.',
            type: 'error'
          })
        })
    }
  }
}
</script>

<style>

</style>
