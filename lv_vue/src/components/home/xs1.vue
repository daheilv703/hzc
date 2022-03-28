<template>
  <div id="xsindexdiv">
    <el-container class="riggContainerCss">
<!--       <el-header class="riggHeaderCss">
        <el-dropdown>
          <i class="el-icon-setting" style="margin-right: 15px"></i>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>查看</el-dropdown-item>
            <el-dropdown-item>新增</el-dropdown-item>
            <el-dropdown-item>删除</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
        <span>王小虎</span>
      </el-header> -->

      <el-main>
       <el-button type="success" size="mini" st     yle="margin-right:9px;">新增商机</el-button>
        <el-table id="tableData"  v-fit-columns :data="tableData" @selection-change="chkChange" :height="height" :row-key="getRowKeys">
          <el-table-column type="selection" :reserve-selection="true" ></el-table-column>
          <template v-for="(item,index) in headArr" >
            <el-table-column :key="index" :prop="item.prop" :label="item.label" align="center">
              <template slot-scope="scope">
                  <span style="center" >{{ scope.row[scope.column.property] }}</span>
              </template>
            </el-table-column>
               <!-- <el-table-column prop="id" label="ID"></el-table-column>
			   <el-table-column prop="bianhao" label="编号"></el-table-column>
			   <el-table-column prop="xiangmu" label="项目" :show-overflow-tooltip="true"></el-table-column>
			   <el-table-column prop="hangye" label="行业"></el-table-column>
			   <el-table-column prop="hetongfang" label="合同方"></el-table-column>
			   <el-table-column prop="quyu" label="区域"></el-table-column>
			   <el-table-column prop="chengshi" label="城市"></el-table-column>
			   <el-table-column prop="chuangjianshijian" :formatter="dateFormat" label="创建时间"></el-table-column>
			   <el-table-column prop="laiyuan" label="来源"></el-table-column>
			   <el-table-column prop="jilv" label="几率"></el-table-column>
			   <el-table-column prop="chanpinleixing" label="产品类型"></el-table-column>
			   <el-table-column prop="cankaoxiangmu" label="参考项目"></el-table-column>
			   <el-table-column prop="yingjian" label="硬件"></el-table-column>
			   <el-table-column prop="xiaoshouleixing" label="销售类型"></el-table-column>
			   <el-table-column prop="caigoujiedian" :formatter="dateFormat" label="采购节点"></el-table-column>
			   <el-table-column prop="jine" label="金额"></el-table-column>
			   <el-table-column prop="jieduan" label="阶段"></el-table-column>
			   <el-table-column prop="beijingmiaoshu" label="背景描述" :show-overflow-tooltip="true"></el-table-column>
			   <el-table-column prop="fuzeren" label="负责人"></el-table-column>
			   <el-table-column prop="updatetime" :formatter="dateFormat" label="更新时间"></el-table-column>
			   <el-table-column prop="updateuser" label="更新人"></el-table-column> -->
            
          </template>
          <el-table-column label="操作" width="100px">
            <template slot-scope="scope">
                <el-button
                        size="mini"
                        @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                <el-button
                        size="mini"
                        type="danger"
                        @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                            <el-dialog title="编辑用户"
               :visible.sync="dialogFormVisible"
               width="500px"
               top="200px">
      <el-form :model="form">
         <el-input v-model="form.index" auto-complete="off" display="none" v-if="false"></el-input>
        <el-form-item label="项目ID" :label-width="formLabelWidth">
          <el-input v-model="form.id" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="项目编号"
                    :label-width="formLabelWidth">
          <el-input v-model="form.bianhao"
                    auto-complete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer"
         class="dialog-footer">
         
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary"
         @click="handleSet(scope.$index, scope.row)">确 定</el-button>
        
      </div>
    </el-dialog>
            </template>
          </el-table-column>
        </el-table>
      </el-main>
    </el-container>
  </div>
</template>
<script>
let moment = require("moment");
export default {
  name: 'xs1',
  inject:['reload'],
  data() {
	  var a = JSON.parse(this.$route.query.itemsss);
      for(let i in a){
        a[i].chuangjianshijian = this.mydateformat(a[i].chuangjianshijian);
        a[i].caigoujiedian = this.mydateformat(a[i].caigoujiedian);
        a[i].updatetime = this.mydateformat(a[i].updatetime);
        
        console.log(a[i].chuangjianshijian);
      };
      return {
    	  dialogFormVisible: false,//弹出层默认为关闭
    	  headArr:[
           　{label:'ID' , prop : 'id'},
            {label:'编号' , prop : 'bianhao'},
            {label:'项目' , prop : 'xiangmu'},
            {label:'行业' , prop : 'hangye'},
            {label:'合同方' , prop : 'hetongfang'},
            {label:'区域' , prop : 'quyu'},
            {label:'城市' , prop : 'chengshi'},
            {label:'创建时间' , prop : 'chuangjianshijian'},
            {label:'来源' , prop : 'laiyuan'},
            {label:'几率' , prop : 'jilv'},
            {label:'产品类型' , prop : 'chanpinleixing'},
            {label:'参考项目' , prop : 'cankaoxiangmu'},
            {label:'硬件' , prop : 'yingjian'},
            {label:'销售类型' , prop : 'xiaoshouleixing'},
            {label:'采购节点' , prop : 'caigoujiedian'},
            {label:'金额' , prop : 'jine'},
            {label:'阶段' , prop : 'jieduan'},
            {label:'背景描述' , prop : 'beijingmiaoshu'},
            {label:'负责人' , prop : 'fuzeren'},
            {label:'创建时间' , prop : 'createtime'},
            {label:'创建人' , prop : 'createuser'},
            {label:'更新时间' , prop : 'updatetime'},
            {label:'更新人' , prop : 'updateuser'},
		],
        tableData: a,
        form: {
          index: "",
          id: "",
          bianhao: ""
        },
        formLabelWidth: '90px',
   	    height: "200px"
      }
    },
    mounted() {
  	    this.getAutoHeight();
  	    const self = this;
        window.onresize = function() {
          self.getAutoHeight();
      	};
  	  },
    methods: {
    	handleEdit (index, row) {
   	      this.dialogFormVisible = true; //开启弹出层
   	      //对弹出层中的表单赋值 
   	      this.form.index = index;
   	  	  this.form.id = row.id;
   	      this.form.bianhao = row.bianhao;
   	    },
   	    
   	    //编辑弹层确定按钮
   	    handleSet (index, row) {
   	      //编辑弹层确定的参数
   	      var params = new URLSearchParams(); 
   	      params.append('id', this.form.id);
       	  params.append('bianhao', this.form.bianhao);
  		 this.$axios
          .post('/updateSjb1',params)
          .then(successResponse => {
        	  console.log(successResponse);
   	          if (successResponse.data.code == 200) {
   	        	 this.dialogFormVisible = false; //开启弹出层
   	        	 this.tableData = JSON.parse(JSON.stringify(successResponse.data.res));
   	            this.$message("修改成功！");
   	            this.reload();
   	          } else {
   	            this.$message("修改失败！");
   	          }
   	        }
   	      ); 
  	    },
        //删除
        handleDelete(index, row) {
	    	 var params = new URLSearchParams(); 
	   	      params.append('id', row.id);
          this.$axios
          .post('/deleteOne',params)
          .then(successResponse => {
   	          if (successResponse.data.code == 200) {
   	        	this.tableData = JSON.parse(JSON.stringify(successResponse.data.res));
   	            this.$message("删除成功！");
   	            this.reload();
   	          } else {
   	            this.$message("删除失败！");
   	          }
   	        }
   	      ); 
        },
        //页面初始化
    	init() {
    		// 也买你初始化方法， 页面一进来，有可能有初始选中数据
        	this.$nextTick(()=>{
              this.setSelectRow()
            })
      	},
      	setSelectRow() {
            this.$nextTick(()=>{
              // 切换页面时， 把被切换的页面的数据存入到selectData中
              this.currentFinalSelectDatasToAllSelectData()

    			// 把当前页面需要选中的进行设置
              this.tableData.forEach((item) => {
              	// selectValIsArrayObj 判断当前这行数据是否在所有需要选中的数据中
                let selectSingleData = selectValIsArrayObj(this.selectData, item.id, 'id')
                
                // 如果当前行数据在所有选中的数据中， 则把当前行勾选上
                if (selectSingleData.id != undefined) {
                	// 调用这个方法会触发@selection-change事件
                  this.$refs.singleTable.toggleRowSelection(item, true)
                }
              })
            })
          },
          getRowKeys(row){
            return row.id // 没一行数据都有唯一的id， 所以这里以id做为table的key
          },
          chkChange(val) {
            // 当前val记录的是所有选择的数据， 不仅仅是当前页， 而是所有页选中的
            // 把当前页的选中数据变量和未选中数据变量值清空， 因为给一页的数据勾选多个时候
            // 会多次触发此方法
            this.toggleToCurrentFinalSelectDatas = []
            this.toggleToCurrentFinalCancelDatas = []

            for (let j=0; j<this.tableData.length; j++) {
             
              let currentRowFind = 0
              for (let i=0; i<val.length; i++) {
                // 判断所有勾选的值里面是否为当前这行数据
                if (val[i].id == this.tableData[j].id) {  
                  currentRowFind = 1
                  break
                }
              }

              // 在所有选中数据中，把当前页的勾选数据存入到toggleToCurrentFinalSelectDatas中，
              // 取消的数据存到toggleToCurrentFinalSelectDatas
              if (currentRowFind == 0) {
                this.toggleToCurrentFinalCancelDatas.push(this.tableData[j])
              } else {
                this.toggleToCurrentFinalSelectDatas.push(this.tableData[j])
              }
            }
          },
          currentFinalSelectDatasToAllSelectData() {
          	// 切换分页和最后提交数据时， 需要调用此方法
    		// 把切换之前的页面选中的数据，合并到selectData中
              this.toggleToCurrentFinalSelectDatas.forEach((item) => {
                let selectSingleData = selectValIsArrayObj(this.selectData, item.id, 'id')

                if (selectSingleData.id == undefined) {
                  this.selectData.push(item)
                }
              });

              // 删除本页取消数据
              this.toggleToCurrentFinalCancelDatas.forEach((item) => {
                // 因为初始话给selectData的数据格式不一样， 所以只能先根据id查找是否存在， 然后再查找索引位置进行删除
                let selectSingleData = selectValIsArrayObj(this.selectData, item.id, 'id')

                if (selectSingleData != undefined) {
                  let deleteIndex = this.selectData.indexOf(selectSingleData)
                  if (deleteIndex > -1) {
                    this.selectData.splice(deleteIndex, 1)
                  }
                }
              });

              this.toggleToCurrentFinalSelectDatas = [];
              this.toggleToCurrentFinalCancelDatas = [];
          },
          // 这个方法用来动态设置el-table的高度
          getAutoHeight() {
            var el = document.querySelector("#tableData");
            var elParent = el.parentNode;
            var pt = this.getStyle(elParent, "paddingTop");
            var pb = this.getStyle(elParent, "paddingBottom");
            
            // 一定要使用 nextTick 来改变height 不然不会起作用
            this.$nextTick(() => {
              this.height = elParent.clientHeight - (pt + pb) + "px";
            });
          },
          // 获取样式 我们需要减掉 padding-top， padding-bottom的值
          getStyle(obj, attr) {
            // 兼容IE浏览器
            let result = obj.currentStyle
              ? obj.currentStyle[attr].replace("px", "")
              : document.defaultView
                  .getComputedStyle(obj, null)[attr].replace("px", "");
            return Number(result);
          },
          //时间格式化
          mydateformat(val) {
            console.log(val);
            // if (val == null || val.length() === 0) {
            //   return "";
            // }else {
	            return moment(val).format("YYYY年MM月DD日");
            // }
          },
          setColumnWidth(val){
            console.log(val)
          }
     }
  };
</script>
<style>
.riggContainerCss {
	width: 100%;
	height: 500px;
	border: 1px solid #eee;
	background-color: rgb(238, 241, 246);
}
.riggHeaderCss {
	text-align: center;
	font-size: 12px
}
.el-row{ margin-bottom: 15px; }
.el-pagination{ margin-top: 20px; }
tableC{ position:relative;}
.el-table th{ height: 60px; }
.el-table td{ padding:0; height: 50px; font-size: 14px; }
.el-table.hide-scrollBar{
    /*隐藏滚动条 设置底部padding20px*/
    scrollbar-width: none; /* Firefox */
    -ms-overflow-style: none; /* IE 10+ */
    padding-bottom: 20px;
}
.el-table.hide-scrollBar ::-webkit-scrollbar { display: none; /* Chrome Safari */ }
.el-main {
  overflow: hidden !important;
}
</style>