<template>
    <div class="home">
      <wchead></wchead>
      <el-row class="content">
      </el-row>
      <wcfooter></wcfooter>
    </div>
</template>
<script>
import wchead from '@/components/head';
import wcfooter from '@/components/footer';

export default {
  name: 'home',
  data () {
    return {

    }
  },
  components:{
    wchead,
    wcfooter
  }
}
</script>
<style scoped>
.content{
  display: flex;
  flex: 1;
  width: 100%;
  height: 44.7rem;
}
</style>
