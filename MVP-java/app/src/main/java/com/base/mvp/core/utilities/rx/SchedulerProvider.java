package com.base.mvp.core.utilities.rx;

import java.util.concurrent.Executor;

import io.reactivex.rxjava3.core.Scheduler;

/**
 * Author: William Giang Nguyen | 9/8/2022
 */
public interface SchedulerProvider {

    /**
     * Cung cấp quyền truy cập đến Main Thread/UI Thread. Thông thường cập nhật giao diện hay tương tác với người dùng sẽ xảy ra trên luồng này. Chúng ta không thực hiện bất kì công việc chuyên sâu trên luồng này vì nó sẽ làm cho ứng dụng bị crash hoặc Android not response.
     */
    Scheduler ui();

    /**
     * Có thể đòi hỏi đến đòi hỏi nhiều CPU như xử lý dữ liệu lớn, xử lý bitmap, … Số lượng các thread được tạo ra bằng cách sử dụng Scheduler này hoàn toàn phụ thuộc vào số lõi CPU.
     */
    Scheduler computation();

    /**
     * Khi dùng cái này thì sẽ không dùng đến CPU, nó thực hiện các công việc chuyên sâu như networks call, đọc đĩa/file, database, … Nó duy trì được pool của thread.
     */
    Scheduler io();

    /**
     * Sử dụng cái này thì mỗi thread sẽ được tạo ra mỗi lần nhiệm vụ được xếp lịch. Thường thì không khuyến cáo sử dụng cách này trừ khi công việc rất dài. Thread được tạo qua newThread() sẽ không được dùng lại.
     */
    Scheduler newThread();

    /**
     * Scheduler này sẽ thực hiện tất cả các nhiệm vụ theo thứ tự tuần tự mà chúc được add vào. Việc này có thể cần thiết trong một số trường hợp cần tuần tự.
     * */
    Scheduler single();

    /**
     * Thực hiện nhiệm vụ ngay lập tức một cách đồng bộ bằng cách chặn main thread.
     * */
    Scheduler immediate();

    /**
     * Thực hiện các nhiệm vụ theo Last In - First Out. Tất cả các nhiệm vụ được xếp lịch sẽ được thực hiện từng cái một bằng cách giới hạn số lượng các background thread thành một.
     * */
    Scheduler trampoline();

    /**
     * Cách này cho phép tạo ra một Scheduler từ một Executor bởi giới hạn số lượng các thread được tạo ra. Khi thread pool bị full, các nhiệm vụ sẽ xếp hàng đợi.
     *
     * Chúng ta đã có những khái niệm cơ bản cần thiết. Giờ hãy bắt đầu với một số khái niệm chính về RxJava mà mọi người nên biết.
     * */
    Scheduler from(Executor executor);
}
