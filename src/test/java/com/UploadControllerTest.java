package com;



import com.dot.s3.service.UploadService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class UploadControllerTest {
    private MockMvc mockMvc;


    @MockBean
    UploadService contactServiceMockBean;


    @Test
    public void doUploadTestMocked() throws Exception {
        String csv = "aa, bb, cc, dd";

        // Mock Request
        MockMultipartFile csvFile = new MockMultipartFile(
                "file.csv",
                "file.csv",
                "text/csv",
                csv.getBytes()
        );
        assertEquals(csvFile.getContentType(), "text/csv");

    }


    @Test
    public void test() throws Exception {
        String csv = "aa, bb, cc, dd";
        // Mock Request
        MockMultipartFile csvFile = new MockMultipartFile(
                "file.csv",
                "file.csv",
                "text/csv",
                csv.getBytes()
        );
        assertEquals(csvFile.getSize(), 14);
    }

    @Test
    public void test2() throws Exception {
        String csv = "aa, bb, cc, dd";
        // Mock Request
        MockMultipartFile csvFile = new MockMultipartFile(
                "file.csv",
                "file.csv",
                "text/csv",
                csv.getBytes()
        );
        assertEquals(csvFile.getName(), "file.csv");
    }
}