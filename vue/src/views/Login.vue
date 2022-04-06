<template>
  <div class="wrapper">
    <div style="margin: 200px auto; background-color: #fff; width: 350px; height: 300px; padding: 20px; border-radius: 10px">
      <div style="margin: 20px 0; text-align: center; font-size: 24px"><b>登 录</b></div>
<!--      <el-form :model="user" :rules="rules" ref="userForm">-->
<!--        <el-form-item prop="username">-->
          <el-input size="medium" style="margin: 10px 0" prefix-icon="el-icon-user" v-model="user.userName"></el-input>
<!--        </el-form-item>-->
<!--        <el-form-item prop="password">-->
          <el-input size="medium" style="margin: 10px 0" prefix-icon="el-icon-lock" show-password
                    v-model="user.userPassword"></el-input>
<!--        </el-form-item>-->
        <div style="margin: 10px 0; text-align: right">
          <el-button type="warning" size="small" autocomplete="off" @click="$router.push('/')">查看留言</el-button>
          <el-button type="warning" size="small" autocomplete="off" @click="$router.push('/register')">注册</el-button>
          <el-button type="primary" size="small" autocomplete="off" @click="login">登录</el-button>
        </div>
<!--      </el-form>-->
    </div>
  </div>


</template>

<script>
export default {
  name: "Login",
  data(){
    return{
      user:{}
    }
  },
  methods:{
    login(){
      // this.request.post("/user/login",this.user).then(res =>{
      //   if(!res){
      //     this.$message.error("错误")
      //   }else{
      //     this.$message.success("成功")
      //     this.$router.push("/")
      //   }
      // })
          this.request.post("/user/login",this.user).then(res=>{
            if(res.tof == true){
              this.$message.success("成功")
              sessionStorage.setItem("token",res.token)

                  this.$router.push("/")
            }else{
              this.$message.error("错误")
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