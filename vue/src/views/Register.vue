<template>
  <div class="wrapper">
    <div style="margin: 200px auto; background-color: #fff; width: 350px; height: 300px; padding: 20px; border-radius: 10px">
      <div style="margin: 20px 0; text-align: center; font-size: 24px"><b>注 册</b></div>
      <!--      <el-form :model="user" :rules="rules" ref="userForm">-->
      <!--        <el-form-item prop="username">-->
      <el-input size="medium" style="margin: 10px 0" prefix-icon="el-icon-user" v-model="user.userName"></el-input>
      <!--        </el-form-item>-->
      <!--        <el-form-item prop="password">-->
      <el-input size="medium" style="margin: 10px 0" prefix-icon="el-icon-lock" show-password
                v-model="user.userPassword"></el-input>
      <!--        </el-form-item>-->
      <div style="margin: 10px 0; text-align: right">
        <el-button type="warning" size="small" autocomplete="off" @click="$router.push('/login')">如有账号，请登录</el-button>
        <el-button type="primary" size="small" autocomplete="off" @click="handlere">点击邮箱验证后注册</el-button>
      </div>
      <!--      </el-form>-->
    </div>
    <el-dialog title="邮箱验证" :visible.sync="dialogFormVisible">
      <el-form >
        <el-form-item label="邮箱地址" :label-width=120 px>
          <el-input v-model="mailput" autocomplete="off"></el-input>
        </el-form-item>
          <el-button  @click="sendmail">发送邮件</el-button>
        <el-button type="info" icon="el-icon-message" circle></el-button>
        <el-form-item label="验证码" :label-width=120 px>
          <el-input v-model="codee.codeValue" autocomplete="off"></el-input>
        </el-form-item>
<!--        <el-form-item label="验证码" :label-width=120 px>-->
<!--          <el-input v-model="codeput" autocomplete="off"></el-input>-->

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="register">确 定</el-button>
      </div>
    </el-dialog>
  </div>


</template>

<script>
export default {
  name: "Login",
  data(){
    return{
      user : {},
      dialogFormVisible:false,
      mailput : "",
      codeput : "",
      codee: {}
    }
  },
  methods:{

    re(){
      this.request.post("/user",this.user).then(res =>{
        if(res){
          this.$message.success("注册成功")
          this.$router.push("/")
        }else{
          this.$message.error("保存失败")
        }
      })
    },
    register(){
      this.request.post("/user/register",this.codee).then(res=>{
        if(res){
          this.$message.success("注册成功")
          this.$router.push("/login")
        }else{
          this.$message.error("保存失败")
        }
      })
    },
    handlere(){
      this.dialogFormVisible = true;
    },
    sendmail(){
      this.request.post("/user/sendMail",this.mailput).then(res=>{
        if(res){
          this.$message.success("邮件发送成功")
        }else{
          this.$message.error("邮件发送失败")
        }
      })
    },
    equcode(){
      this.request.get("/user/eqlCode",this.codeput).then(res=>{
        if(res){
          this.request.post("/user",this.user).then(res =>{
            if(res){
              this.$message.success("注册成功")
              this.$router.push("/login")
            }else{
              this.$message.error("保存失败")
            }
          })

        }else{
          this.$message.error("验证码错误")
        }
      })
    }

  }
}
</script>

<style scoped>
.wrapper {
  height: 100vh;
  background-image: linear-gradient(to bottom right,#42b983 ,#409EFF);
  overflow: hidden;
}
</style>