# Employee-Management-System
REST API using Spring Boot

![alt text](https://github.com/whoparthgarg/Employee-Management-System/blob/main/spring-boot-architecture.png)

This document provides an overview of the Employee Management API, including endpoints, request/response formats, and example `curl` commands for each operation.

## Table of Contents
1. [Introduction](#introduction)
2. [Endpoints](#endpoints)
    - [Create Employee](#create-employee)
    - [Get All Employees](#get-all-employees)
    - [Get Employee by ID](#get-employee-by-id)
    - [Update Employee](#update-employee)
    - [Delete Employee](#delete-employee)

## Introduction

The Employee Management API allows for creating, retrieving, updating, and deleting employee records. This API is implemented using Spring Boot and provides a set of RESTful endpoints to manage employee data.

## Endpoints

### Create Employee

- **URL:** `/api/create`
- **Method:** `POST`
- **Status Code:** `201 Created`
- **Request Body:**
  ```json
  {
      "firstName": "John",
      "lastName": "Doe",
      "mobileNumber": "123-456-7890",
      "email": "john.doe@example.com"
  }

### Get All Employees

- **URL:** `/api/get/all`
- **Method:** `GET`
- **Response:**
  - **Status:** `200 OK`
  - **Body:**
    ```json
    [
        {
            "id": 1,
            "firstName": "John",
            "lastName": "Doe",
            "mobileNumber": "123-456-7890",
            "email": "john.doe@example.com"
        },
        {
            "id": 2,
            "firstName": "Jane",
            "lastName": "Smith",
            "mobileNumber": "987-654-3210",
            "email": "jane.smith@example.com"
        }
    ]
    ```

### Get Employee by ID

- **URL:** `/api/get/{id}`
- **Method:** `GET`
- **Path Variable:** `id` (long)
- **Response:**
  - **Status:** `200 OK`
  - **Body:**
    ```json
    {
        "id": 1,
        "firstName": "John",
        "lastName": "Doe",
        "mobileNumber": "123-456-7890",
        "email": "john.doe@example.com"
    }
    ```

### Update Employee

- **URL:** `/api/update/{id}`
- **Method:** `PUT`
- **Path Variable:** `id` (long)
- **Request Body:**
  ```json
  {
      "firstName": "John",
      "lastName": "Doe",
      "mobileNumber": "123-456-7890",
      "email": "john.doe@example.com"
  }

### Delete Employee

- **URL:** `/api/delete/{id}`
- **Method:** `DELETE`
- **Path Variable:** `id` (long)
- **Response:**
  - **Status:** `200 OK`
  - **Body:**
    ```json
    "Employee Record Deleted for ID: 1"
    ```
