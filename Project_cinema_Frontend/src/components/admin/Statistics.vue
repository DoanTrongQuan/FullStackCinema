<template>
        <div class="row">
        <div class="col-xl-3 col-lg-6 col-sm-12 effect">
            <div class="card  custom-card" >
                <div class="flex justify-content-between mb-3">
                    <div>
                        <span class="block text-500 font-medium mb-3">Người dùng</span>
                        <div class="text-900 font-medium text-xl">{{ totalUserCount }}</div>
                    </div>
                    <div class="flex align-items-center justify-content-center bg-blue-100 " style="border-radius: 5px !important;width: 2.5rem; height: 2.5rem; background-color: #d0e1fd !important;">
                        <i class="pi pi-users text-blue-500 text-xl"></i>
                    </div>
                </div>
                <span class="text-green-500 font-medium">Tổng số tài khoản</span>
            </div>
        </div>
        <div class="col-xl-3 col-lg-6 col-sm-12 effect">
            <div class="card  custom-card">
                <div class="flex justify-content-between mb-3">
                    <div>
                        <span class="block text-500 font-medium mb-3">Vô hiệu hóa</span>
                        <div class="text-900 font-medium text-xl">{{ totalUserLocked }}</div>
                    </div>
                    <div class="flex align-items-center justify-content-center bg-orange-100 border-round" style="border-radius: 5px !important;width: 2.5rem; height: 2.5rem;background-color: #feddc7 !important;">
                        <i class="pi pi-lock text-orange-500 text-xl"></i>
                    </div>
                </div>
                <span class="text-green-500 font-medium">Tài khoản bị vô hiệu hóa</span>

            </div>
        </div>
        <div class="col-xl-3 col-lg-6 col-sm-12 effect">
            <div class="card mb-0 custom-card">
                <div class="flex justify-content-between mb-3">
                    <div>
                        <span class="block text-500 font-medium mb-3">Khóa học</span>
                        <div class="text-900 font-medium text-xl">{{ totalCourseCount }}</div>
                    </div>
                    <div class="flex align-items-center justify-content-center bg-cyan-100 border-round" style="border-radius: 5px !important;width: 2.5rem; height: 2.5rem;background-color: #c3edf5 !important;">
                        <i class="pi pi-briefcase text-cyan-500 text-xl"></i>
                    </div>
                </div>
                <span class="text-green-500 font-medium">Tổng số khóa học</span>
            </div>
        </div>
        <div class="col-xl-3 col-lg-6 col-sm-12 effect">
            <div class="card mb-0 custom-card">
                <div class="flex justify-content-between mb-3">
                    <div>
                        <span class="block text-500 font-medium mb-3">Bài đăng</span>
                        <div class="text-900 font-medium text-xl">{{ totalPostCount }}</div>
                    </div>
                    <div class="flex align-items-center justify-content-center bg-purple-100 border-round" style="border-radius: 5px !important;width: 2.5rem; height: 2.5rem;background-color: #ead6fd !important;">
                        <i class="pi pi-upload text-purple-500 text-xl"></i>
                    </div>
                </div>
                <span class="text-green-500 font-medium">Tổng số bài đăng</span>
            </div>
        </div>
        </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import AdminService from '@/service/admin/admin.service.js';

const totalUserCount = ref(0);
const totalUserLocked = ref(0);
const totalPostCount = ref(0);
const totalCourseCount = ref(0);

// onMounted(
//     async () => {
//     try {
//         const resUserCount = await AdminService.getTotalUserCount();
//         totalUserCount.value = resUserCount.data;
//     } catch (error) {
//         alert("Error fetching total user count");
//     }

//     try {
//         const resUserLocked = await AdminService.getTotalUserLocked();
//         totalUserLocked.value = resUserLocked.data;
//     } catch (error) {
//         alert("Error fetching total user locked count");
//     }

//     try {
//         const resCourseCount = await AdminService.getTotalCourseCount();
//         totalCourseCount.value = resCourseCount.data;
//     } catch (error) {
//         alert("Error fetching total course count");
//     }

//     try {
//         const resPostCount = await AdminService.getTotalPostCount();
//         totalPostCount.value = resPostCount.data;
//     } catch (error) {
//         alert("Error fetching total post count");
//     }
// }
// );
</script>


<style scoped>
.effect{
    transition: transform 0.2s ease;
    padding-top: 5px;
    padding-bottom: 5px;

}
.effect:hover {
    transform: translateY( -5px );
}
.custom-card{
    border: none  !important;
    border-radius: 20px !important;
}
</style>