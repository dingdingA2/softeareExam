<template>
  <div> <!-- 添加一个包裹所有内容的单一根元素 -->
    <div style="padding: 10px; width: 100%; height: 100vh">
      <!-- 功能区域 -->
      <div style="margin: 10px 0">
        <el-button type="primary" @click="add"><i class="el-icon-circle-plus-outline"></i>新增</el-button>
        <el-popconfirm
            style="margin: 6px"
            confirm-button-text='确定'
            cancel-button-text='我再想想'
            icon="el-icon-info"
            icon-color="red"
            title="您确定删除吗？"
            @onConfirm="handleDelete(scope.row.id)"
        >
          <el-button type="danger" slot="reference"><i class="el-icon-remove-outline"></i>批量删除</el-button>
        </el-popconfirm>
        <el-button type="primary" style="margin-left: 5px"><i class="el-icon-bottom"></i>导入</el-button>
        <el-button type="primary"><i class="el-icon-top"></i>导出</el-button>
      </div>
      <!-- 搜索区域 -->
      <div style="margin: 10px 0">
        <el-input v-model="search" placeholder="请输入关键字" style="width: 20%" suffix-icon="el-icon-search"
                  clearable></el-input>
        <el-button type="primary" style="margin-left: 5px" @click="searchName">查询</el-button>
      </div>
      <el-table
          :data="tableData"
          border
          stripe
          style="width: 100%"
      >
        <!-- 表格列定义 -->
        <el-table-column
            prop="id"
            label="ID"
            sortable
            width="180"
        ></el-table-column>
        <el-table-column
            prop="username"
            label="用户名"
            width="180"
        ></el-table-column>
        <el-table-column
            prop="nickname"
            label="昵称"
        ></el-table-column>

        <el-table-column
            prop="age"
            label="年龄"
        ></el-table-column>
        <el-table-column
            prop="sex"
            label="性别"
        ></el-table-column>
        <el-table-column
            prop="address"
            label="地址"
        ></el-table-column>
        <el-table-column
            label="操作"
            width="150"
        >
          <template slot-scope="scope">
            <el-button size="mini" @click="handleEdit(scope.row)" type="primary" style="margin-right: 10px">
              编辑
            </el-button>
            <el-popconfirm
                style="margin-left: 5px"
                confirm-button-text='确定'
                cancel-button-text='我再想想'
                icon="el-icon-info"
                icon-color="red"
                title="您确定删除吗？"
                @confirm="handleDelete(scope.row.id)"
            >
              <el-button size="mini" slot="reference" type="danger">删除</el-button>
            </el-popconfirm>
          </template>
        </el-table-column>
      </el-table>
      <div style="margin: 10px 0">
        <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="currentPage"
            :page-sizes="[5, 10, 20]"
            :page-size="pageSize"
            layout="total, sizes, prev, pager, next, jumper"
            :total="total"
        ></el-pagination>
        <!-- 弹出框 -->
        <el-dialog title="用户信息" :visible.sync="dialogVisible" width="30%">
          <el-form label-width="80px" :model="form" size="small">
            <el-form-item label="用户名">
              <el-input v-model="form.username"></el-input>
            </el-form-item>
            <el-form-item label="密码">
              <el-input v-model="form.password"></el-input>
            </el-form-item>
            <el-form-item label="昵称">
              <el-input v-model="form.nickname" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="年龄">
              <el-input v-model="form.age" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="性别">
              <el-input v-model="form.sex" autocomplete="off"></el-input>
              <el-radio v-model="form.sex" label="男">男</el-radio>
              <el-radio v-model="form.sex" label="女">女</el-radio>
              <el-radio v-model="form.sex" label="未知">未知</el-radio>
            </el-form-item>
            <el-form-item label="地址">
              <el-input type="textarea" v-model="form.address" autocomplete="off"></el-input>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="save">确 定</el-button>
          </div>
        </el-dialog>
      </div>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src


import request from "@/utils/request";

export default {
  name: 'HomeView',
  components: {},
  data() {
    return {
      form: {
        id: '',
        username: '',
        nickname: '',
        age: '',
        sex: '',
        address: '',
        password: ''
      },
      dialogVisible: false,// 弹出框初始是否 显示
      currentPage: 1,
      total: 0,
      search: '',
      pageSize: 10,
      pageNum: 1,
      tableData: []
    }
  },
  created() {
    this.load()
  },
  methods: {
    load() {
      request.get("user", {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          search: this.search
        }
      }).then(res => {
        console.log(res)
        this.tableData = res.data.records
        this.total = res.data.total
      })
    },
    searchName() {
      if (this.search == ''){
        this.load()
      }
      else {
        request.get(`user/search/${encodeURIComponent(this.search)}`, {
        }).then(res => {
          console.log(res)
          this.tableData = res.data.records
          this.total = res.data.total
        })
      }
    },
    handleSizeChange(pageSize) {//改变当前每页个数触发
      this.pageSize = pageSize
      this.load()
    },
    handleCurrentChange(pageNum) { //改变当前页码触发
      this.currentPage = pageNum
      this.pageNum = pageNum
      this.load()
    },
    handleEdit(row) {
      this.form = JSON.parse(JSON.stringify(row))
      this.dialogVisible = true
    },
    handleDelete(id) {
      request.delete("user/del/" + id).then(res => {
        if (res) {
          this.$message.success("删除成功")
          this.load()
        } else {
          this.$message.error("删除失败")
        }
      })
    },

    add() {
      this.dialogVisible = true
      this.form = {}
    },
    save() {
      console.log(this.form.id)
      if (this.form.id) {
        //更新
        request.put("user", this.form).then(res => {
          this.load()
          if (res) {
            this.$message.success("更新成功")
          } else {
            this.$message.error("更新失败")
          }
        })
      } else {
        request.post("user/save", this.form).then(res => {
          this.load()
          if (res) {
            this.$message.success("添加成功")
            this.load()
            this.dialogVisible = false
          } else {
            this.$message.error("添加失败")
            this.dialogVisible = false
          }
        })
      }

    },
  }
}
</script>
