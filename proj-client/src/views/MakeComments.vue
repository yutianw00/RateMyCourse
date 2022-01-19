<template>
<div>
    <h1>Make a comment here!</h1>
    <div class="left">
        <h3>All your comments:</h3>
        <el-tabs type="card" :stretch=true>
            <el-tab-pane label="for Courses!">
                <h3>Course</h3>
                <el-scrollbar ref="scrollMenuRef" class="scrollMenuBox" v-if="profEvalData.length != 0">
                    <div v-for="(comment,idx) in courseEvalData" :key="idx">
                        <el-card class="box-card">
                            <p>
                                <b>Course Number: </b> {{ comment.coursenumber }};
                                <b>Semester: </b> {{comment.semester }}
                            </p>
                            <p><b>Professor Name:</b> {{ comment.profname }}</p>
                            <p><b>Rating: </b> {{ comment.rating }} </p>
                            <p><b>Comment: </b> {{ comment.comment }} </p>
                        </el-card>
                        <br/>
                    </div>
                </el-scrollbar>
                <h3 v-if="profEvalData.length == 0">No comment has been made yet!</h3>
            </el-tab-pane>
            <el-tab-pane label="for Professors!">
                <h3>Professor</h3>
                <el-scrollbar ref="scrollMenuRef" class="scrollMenuBox" v-if="courseEvalData.length != 0">
                    <div v-for="(comment,idx) in profEvalData" :key="idx">
                        <el-card class="box-card">
                            <p><b>Professor Name: </b> {{ comment.profname }}</p>
                            <p><b>Rating: </b> {{ comment.rating }} </p>
                            <p><b>Comment: </b> {{ comment.comment }} </p>
                        </el-card>
                        <br/>
                    </div>
                </el-scrollbar>
                <h3 v-if="profEvalData.length == 0">No comment has been made yet!</h3>
            </el-tab-pane>
        </el-tabs>
    </div>
    <div class="right">
        <h3>Make a comment ...</h3>
        <el-tabs type="card" :stretch=true>
            <el-tab-pane label="for a Course!">
                <div class="course-form">
                    <br/><br/>
                    <el-form :model="courseForm" status-icon ref="form" label-width="120px" class="demo-ruleForm">
                    <el-form-item label="Course Number" prop="coursenumber" size="mini">
                        <el-input type="number" v-model="courseForm.coursenumber" placeholder="5 digit course number (e.g., 15112)"></el-input>
                    </el-form-item>
                    <el-form-item label="Professor Name" prop="profname" size="mini">
                        <el-input placeholder="Professor name" v-model="courseForm.profname"></el-input>
                    </el-form-item>
                    <el-form-item label="Semester" prop="semester" size="mini">
                        <el-input v-model="courseForm.semester" placeholder="the semester of this course (e.g. S20, F19, U21...)"></el-input>
                    </el-form-item>
                    <el-form-item label="Course Rating" prop="rating" size="mini">
                        <el-input type="number" v-model="courseForm.rating" placeholder="rating of the course, an integer from 1 to 5"></el-input>
                    </el-form-item>
                    <el-form-item label="Course Evaluation" prop="comment" size="mini">
                        <el-input placeholder="Evaluation for the course" v-model="courseForm.comment"></el-input>
                    </el-form-item>
                    </el-form>
                    <br/><br/>
                    <span slot="footer" class="dialog-footer">
                    <el-button type="primary" size="mini" @click="addCourseEvalData">Confirm</el-button>
                    </span>
                    <br/><br/><br/><br/>
                </div>
            </el-tab-pane>
            <el-tab-pane label="for a Professor!">
                <div class="prof-form">
                    <br/><br/><br/><br/>
                    <el-form :model="profForm" status-icon ref="form" label-width="150px" class="demo-ruleForm">
                        <el-form-item label="Professor Name" prop="profname" size="mini">
                            <el-input placeholder="Professor name" v-model="profForm.profname"></el-input>
                        </el-form-item>
                        <el-form-item label="Professor Rating" prop="rating" size="mini">
                            <el-input type="number" v-model="profForm.rating" placeholder="rating of the professor, an integer from 1 to 5"></el-input>
                        </el-form-item>
                        <el-form-item label="Professor Evaluation" prop="comment" size="mini">
                            <el-input placeholder="Evaluation for the professor" v-model="profForm.comment"></el-input>
                        </el-form-item>
                    </el-form>
                    <br/><br/>
                    <span slot="footer" class="dialog-footer">
                        <el-button type="primary" size="mini" @click="addProfEvalData">Confirm</el-button>
                    </span>
                    <br/><br/><br/><br/>
                </div>
            </el-tab-pane>
        </el-tabs>
    </div>
</div>

</template>

<script>
import { API } from '@/api/index'
import { mapGetters } from 'vuex'

export default {
  data () {
    return {
      courseForm: {},
      profForm: {},
      profEvalData: [],
      courseEvalData: []
    }
  },
  computed: {
    ...mapGetters([
      'username'
    ])
  },
  created () {
    this.getProfData()
    this.getCourseData()
  },
  methods: {
    getProfData () {
      this.profEvalData = []
      var currUser = this.username
      API.getProfEvalsByUser(currUser)
        .then((res) => {
          this.profEvalData = res
        }).catch((err) => {
          console.log(err)
        })
    },
    getCourseData () {
      this.courseEvalData = []
      var currUser = this.username
      API.getCourseEvalsByUser(currUser)
        .then((res) => {
          this.courseEvalData = res
        }).catch((err) => {
          console.log(err)
        })
    },
    addProfEvalData () {
      let params = new URLSearchParams()
      params.append('profname', this.profForm.profname)
      params.append('user', this.username)
      params.append('rating', this.profForm.rating)
      params.append('comment', this.profForm.comment)
      API.addProfEval(params)
        .then(res => {
          if (res) {
            this.getProfData()
            this.profForm = {}
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
    },
    addCourseEvalData () {
      let params = new URLSearchParams()
      params.append('user', this.username)
      params.append('coursenumber', this.courseForm.coursenumber)
      params.append('profname', this.courseForm.profname)
      params.append('semester', this.courseForm.semester)
      params.append('rating', this.courseForm.rating)
      params.append('comment', this.courseForm.comment)
      API.addCourseEval(params)
        .then(res => {
          if (res) {
            this.getCourseData()
            this.profForm = {}
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

<style scoped>
.left {
    float: left;
    width: 47%;
    margin: auto auto 1% 2%;
    background-color: azure;
    height: 500px;
}
.right {
    float: left;
    width: 47%;
    margin: auto auto 2% 1%;
    background-color: rgb(240, 243, 255);
    font-size: 16px;
    height: 500px;
}

.course-form {
    width: 80%;
    margin: auto;
}

.prof-form {
    width: 80%;
    margin: auto;
}

.scrollMenuBox {
    height: 300px;
    width: 80%;
    margin: auto;
    /* border: 1px solid red; */
}

.box-card {
    height: 200px;
}

</style>
