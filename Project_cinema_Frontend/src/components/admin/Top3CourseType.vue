<script setup>
import {ref, computed, onMounted} from 'vue'
import PublicService from "@/service/public.service.js"

const page = ref(1)
const itemsPerPage = ref(5)
const loading = ref(true)
const search = ref('')
const headers = ref([
          {
            align: 'center',
            key: 'image',
            sortable: false,
            title: 'Hình ảnh',
            class: 'bold-title',
          },
          { title: 'Khóa học', key: 'course',align: 'center', },
          { title: 'Loại khóa học', key: 'courseType',align: 'center', },
          { title: 'Bài học', key: 'lesson',align: 'center', },
          { title: 'Giờ học', key: 'totalTimeLesson',align: 'center', }    
      ])
  
const desserts = ref([])

// onMounted( 
//   async() => {
//   try {
//     const res = await PublicService.getTop3CourseType();
//           res.data.forEach(element => {
//             const course = {
//               image: element[0],
//               course: element[1],
//               courseType: element[2],
//               lesson:element[3],
//               totalTimeLesson:element[4]
//             }
//             desserts.value.push(course)
//           });
    
//   } catch (error) {
//     alert("Có lỗi xảy ra vui lòng tải lại")
//   }finally{
//     loading.value = false;
//   }
// }
// )

const pageCount = computed(() => {
    return Math.ceil(desserts.value.length / itemsPerPage.value)
})

</script>
<template>
  <div class="top3-course-type ">
    <div>
      <h2>Khóa học phổ biến</h2>
    </div>
    <v-data-table
    style="border-radius: 10px;"
    hover
    :loading = "loading"
    loading-text="Loading... Please wait"
    v-model:page="page"
    v-model:search="search"
    :headers="headers"
    :items="desserts"
    :items-per-page="itemsPerPage"
    >
    <template v-slot:item.image = {item}>
      <v-card class="my-2" elevation="2" rounded style="width: 100%;">
            <v-img
              :src="item.image"
              height="64"
              cover
            ></v-img>
      </v-card>
    </template>
    <template v-slot:top>
      <div style="display: flex; align-items: center;">
      <v-text-field style="width: 50px !important;"
        :model-value="itemsPerPage"
        class="pa-2"
        hide-details
        variant="solo"
        label="Items per page"
        min="-1"
        max="15"
        type="number"
        @update:model-value="itemsPerPage = parseInt($event, 10)"
      ></v-text-field>

      <v-spacer></v-spacer>
      <v-text-field
        v-model="search"
        prepend-inner-icon="mdi-magnify"
        density="compact"
        label="Search"
        single-line
        flat
        hide-details
        variant="solo"
      ></v-text-field>
    </div>
 
    </template>

    <template v-slot:bottom>
      <div class="text-center pt-2">
        <v-pagination
          v-model="page"
          :length="pageCount"
        ></v-pagination>
      </div>
    </template>
  </v-data-table>
</div>
</template>


<style scoped>
.bold-title {
  font-weight: bold;
}
.top3-course-type {
  transition: transform 0.2s ease;
}

.top3-course-type:hover {
  transform: translateY(-3px);
}
</style>