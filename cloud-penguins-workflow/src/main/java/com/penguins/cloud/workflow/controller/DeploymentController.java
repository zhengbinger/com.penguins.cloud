package com.penguins.cloud.workflow.controller;

import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.repository.Deployment;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.repository.ProcessDefinitionQuery;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengbing
 * @date 2021/1/25
 * @email mydreambing@126.com
 */
@RestController
public class DeploymentController {

    private final Logger log = LoggerFactory.getLogger(DeploymentController.class);

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    /**
     * 部署流程
     * @return
     */
    @GetMapping("deploy")
    public String bpmnImport() {
        Deployment deploy = repositoryService
                .createDeployment()
                 .name("请假申请")
                .addClasspathResource("diagram_1.bpmn")
                .deploy();
        log.info(deploy.getName());
        log.info(deploy.getId());
        ProcessDefinitionQuery qdq = repositoryService.createProcessDefinitionQuery().active();
        return deploy.getName();
    }

    /**
     * 开始流程 -  创建流程实例
     * @param proInsKey
     * @return
     */
    @GetMapping("start")
    public String startBpm(String proInsKey){
        ProcessInstance instance = runtimeService.startProcessInstanceByKey(proInsKey);
        String id = instance.getId();
        log.info(id);
        return id;
    }

    /**
     * 完成一个任务，不带参数
     * @param taskId taskId
     * @return String
     */
    @GetMapping("complite/non/{taskId}")
    public String comTask(@PathVariable String taskId){
        taskService.complete(taskId);
        log.info(taskId);
        return taskId;
    }

    /**
     * 完成一个任务 -  带参数
     *
     * @param taskId - 任务ID
     * @return string
     */
    @GetMapping("complite/param/{taskId}")
    public String comTask2(@PathVariable String taskId) {
        Map<String, Object> param = new HashMap<>();
        param.put("ts", 8);
        taskService.complete(taskId, param);
        return param.toString();
    }

    @GetMapping("/{proDefKey}")
    public String hello(@PathVariable String proDefKey) {
        ProcessDefinition definition = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey(proDefKey).singleResult();

        log.info(definition.getId());
        return definition.getId();
    }
}
