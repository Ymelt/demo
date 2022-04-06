<template>
  <div >
    <el-input v-model="keyword" style="width:200px" placeholder="请输入内容"  suffix-icon="el-icon-search"></el-input>
    <el-button @click="load">{{msg}}</el-button>

    <el-button type="primary" size="small" autocomplete="off" @click="$router.push('/login')">登录</el-button>
    <el-button @click="handleAdd">编写留言</el-button>

    <el-dialog title="写字板" :visible.sync="dialogFormVisible">
      <el-form >
        <el-form-item label="内容" :label-width="formLabelWidth">
          <el-input v-model="form.content" autocomplete="off"></el-input>
        </el-form-item>


      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="save">确 定</el-button>
      </div>
    </el-dialog>



<!--    主题框-->
    <el-main>
      <el-table :data="tableData">
        <el-table-column prop="userId" label="编号" width="90">
        </el-table-column>
        <el-table-column prop="content" label="留言内容" width="200">
        </el-table-column>
        <el-table-column prop="dropTime" label="留言时间">
        </el-table-column>
      </el-table>
    </el-main>


<!--    分页搜索-->
    <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="pageNum"
        :page-sizes="[2, 5, 10, 20]"
        :page-size="5"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total">
    </el-pagination>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
// import request from "@/utils/request";

export default {
  name: 'HomeView',
  components: {
    HelloWorld
  },
  data(){
    return {
      msg:"搜索",
      findit:"编写留言",
      input: '',
      tableData:[],
      total:0,
      pageNum:1,
      pageSize:5,
      keyword:"",
      dialogFormVisible:false,
      form:""
    }
  },
  //请求分页查询数据
  created(){
    this.load()
  },
  methods:{
    load(){
      this.request.get("/word/page" ,{
         params:{
           pageNum : this.pageNum,
           pageSize : this.pageSize,
           keyword : this.keyword

           }
          }).then(res => {
        console.log(res)
        this.tableData = res.records
        this.total = res.total
      })
      // request.get("http://localhost:9090/word/page?pageNum="+this.pageNum+"&pageSize="+this.pageSize+"&keyword="+this.keyword).then(res=>{
      //   console.log(res)
      // })

    },
    handleAdd(){

      this.dialogFormVisible = true;
      this.form = {}
    },
    save(){
      this.request.post("/word/save",this.form).then(res =>{
        if(res){

          this.$message.success("保存成功")
          this.dialogFormVisible = false;
        }else{
          this.$message.error("保存失败")
        }
      })
    },

    handleSizeChange(pageSize){
      console.log(pageSize)
      this.pageSize = pageSize
      this.load()
    },
    handleCurrentChange(pageNum){
      console.log(pageNum)
      this.pageNum = pageNum
      this.load()
    }
  }

}
</script>
