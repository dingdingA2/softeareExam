<script>
export default {
  name: "Header"
}
</script>

<template>

  <div
      style="height: 50px; line-height: 50px; border-bottom: 1px solid #ccc; display: flex; justify-content: flex-end; width: 100%">
    <div style="flex: 200px; padding-left: 30px;font-weight: bold; color: dodgerblue">后台管理</div>
    <div style="flex: 1"></div>
    <div style="flex: 100px; text-align: right;padding-right: 20px">
      <el-dropdown>
  <span class="el-dropdown-link">
    张三<i class="el-icon-arrow-down el-icon--right"></i>
  </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item>系统管理</el-dropdown-item>
          <el-dropdown-item>各种管理</el-dropdown-item>
          <el-dropdown-item @click.native="$router.push('/login')">退出系统</el-dropdown-item>
<!--          native 在这段代码中的意思是 点击事件用来 跳转到 login 页面-->
          <el-dropdown-item disabled>双皮奶</el-dropdown-item>
          <el-dropdown-item divided>蚵仔煎</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
  </div>


</template>

<style>
.el-dropdown-link {
  cursor: pointer;
  color: #409EFF;
}
.el-icon-arrow-down {
  font-size: 12px;
}
</style>