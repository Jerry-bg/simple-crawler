<template>
    <div class="wc-head">
        <el-row>
            <el-col :span="4" class="wc-row">
                <img src="../assets/logo.png"/>
            </el-col>
            <el-col :span="16">
                <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" background-color="#171F26" text-color="#fff" active-text-color="#ffd04b" @select="test">
                    <el-menu-item index="1">首页</el-menu-item>
                    <el-submenu index="2">
                        <template slot="title">消息中心</template>
                        <el-menu-item index="2-1">未读消息</el-menu-item>
                        <el-menu-item index="2-2">订阅消息</el-menu-item>
                    </el-submenu>
                    <el-menu-item index="3">关于我们</el-menu-item>
                </el-menu>
            </el-col>
            <el-col :span="4" style="margin-top:10px;">
                <el-popover placement="bottom" width="100" trigger="hover">
                    <el-row type="flex" justify="space-around">
                        <el-button type="text" @click="test">Login</el-button>
                        <el-button type="text" @click="test">Register</el-button>
                    </el-row>
                    <el-avatar slot="reference" icon="el-icon-user-solid"></el-avatar>
                </el-popover>
            </el-col>
        </el-row>
    </div>    
</template>
<script>
export default {
    name: 'wc_head',
    serviceUrl:{
        API_LOGIN:'/login?account={account}&pwd={pwd}',
        API_REGISTER:'/register'
    },
    data(){
        return{
            activeIndex:'1',
            url:"/test",
            registerInfo:{
                name:'',
                account:'',
                password:''
            }
        }
    },
    methods:{
        login:function(){
            let _this=this;
            let urls=this.HOST+this.url;
            this.axios.get(urls).then((response) => {
                console.log(response.data);
                _this.$message({
                    message:response.data,
                    type:'success'
                });
            })
        },
        test:function(index){
            this.$message({
                    message:"hello"+"--"+index,
                    type:'success'
                });
        },
        register:function(){
            let _this=this;
            let url=this.HOST+this.$serviceUrl.API_REGISTER;
            this.axios.post(url,this.registerInfo)
        }
    }
}
</script>
<style>
    .wc-head{
        width: 100%;
        height: 3.78rem;
        background-color: #171F26;
    }
</style>