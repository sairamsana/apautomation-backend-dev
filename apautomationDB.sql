USE [master]
GO
/****** Object:  Database [apautomation]    Script Date: 2023-03-11 1:24:52 PM ******/
CREATE DATABASE [apautomation]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'apautomation', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\apautomation.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'apautomation_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\apautomation_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [apautomation] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [apautomation].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [apautomation] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [apautomation] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [apautomation] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [apautomation] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [apautomation] SET ARITHABORT OFF 
GO
ALTER DATABASE [apautomation] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [apautomation] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [apautomation] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [apautomation] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [apautomation] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [apautomation] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [apautomation] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [apautomation] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [apautomation] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [apautomation] SET  DISABLE_BROKER 
GO
ALTER DATABASE [apautomation] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [apautomation] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [apautomation] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [apautomation] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [apautomation] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [apautomation] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [apautomation] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [apautomation] SET RECOVERY FULL 
GO
ALTER DATABASE [apautomation] SET  MULTI_USER 
GO
ALTER DATABASE [apautomation] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [apautomation] SET DB_CHAINING OFF 
GO
ALTER DATABASE [apautomation] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [apautomation] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [apautomation] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [apautomation] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'apautomation', N'ON'
GO
ALTER DATABASE [apautomation] SET QUERY_STORE = OFF
GO
USE [apautomation]
GO
/****** Object:  User [sana]    Script Date: 2023-03-11 1:24:52 PM ******/
CREATE USER [sana] FOR LOGIN [sana] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[Approvals]    Script Date: 2023-03-11 1:24:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Approvals](
	[appid] [varchar](255) NULL,
	[status] [nchar](10) NULL,
	[approved_by] [varchar](255) NULL,
	[approved_on] [datetime] NULL,
	[billid] [varchar](256) NULL,
	[comments] [text] NULL,
	[createdby] [varchar](255) NULL,
	[updatedby] [varchar](255) NULL,
	[createdon] [datetime] NULL,
	[updatedon] [datetime] NULL,
	[isdeleted] [bit] NULL,
	[isactive] [bit] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[bills]    Script Date: 2023-03-11 1:24:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[bills](
	[billid] [varchar](256) NOT NULL,
	[name] [varchar](256) NOT NULL,
	[amount] [float] NOT NULL,
	[tax] [float] NULL,
	[billdate] [date] NOT NULL,
	[deptname] [varchar](256) NOT NULL,
	[userid] [varchar](255) NULL,
	[filename] [varchar](256) NULL,
	[createdby] [varchar](256) NULL,
	[updatedby] [varchar](256) NULL,
	[createdon] [datetime] NULL,
	[updatedon] [datetime] NULL,
	[isdeleted] [bit] NULL,
	[isactive] [bit] NULL,
 CONSTRAINT [PK_bills] PRIMARY KEY CLUSTERED 
(
	[billid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Departments]    Script Date: 2023-03-11 1:24:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Departments](
	[deptid] [varchar](255) NOT NULL,
	[name] [varchar](255) NOT NULL,
	[createdby] [varchar](255) NULL,
	[updatedby] [varchar](255) NULL,
	[createdon] [datetime] NULL,
	[updatedon] [datetime] NULL,
	[isdeleted] [bit] NULL,
	[isactive] [bit] NULL,
 CONSTRAINT [PK_Departments] PRIMARY KEY CLUSTERED 
(
	[deptid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Stores]    Script Date: 2023-03-11 1:24:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Stores](
	[storeid] [varchar](255) NOT NULL,
	[name] [varchar](255) NOT NULL,
	[createdby] [varchar](255) NULL,
	[updatedby] [varchar](255) NULL,
	[createdon] [datetime] NULL,
	[updatedon] [datetime] NULL,
	[isdeleted] [bit] NULL,
	[isactive] [bit] NULL,
 CONSTRAINT [PK_Stores] PRIMARY KEY CLUSTERED 
(
	[storeid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[user_department]    Script Date: 2023-03-11 1:24:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user_department](
	[userid] [varchar](255) NOT NULL,
	[deptid] [varchar](255) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 2023-03-11 1:24:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[userid] [varchar](255) NOT NULL,
	[firstname] [varchar](50) NULL,
	[lastname] [varchar](50) NULL,
	[password] [varchar](255) NULL,
	[email] [varchar](255) NULL,
	[mobile] [varchar](50) NULL,
	[createdby] [varchar](255) NULL,
	[updatedby] [varchar](255) NULL,
	[createdon] [datetime] NULL,
	[updatedon] [datetime] NULL,
	[isdeleted] [bit] NULL,
	[isverified] [bit] NULL,
	[isactive] [bit] NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[userid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Approvals]  WITH CHECK ADD  CONSTRAINT [FK_Approvals_Bills] FOREIGN KEY([billid])
REFERENCES [dbo].[bills] ([billid])
GO
ALTER TABLE [dbo].[Approvals] CHECK CONSTRAINT [FK_Approvals_Bills]
GO
ALTER TABLE [dbo].[bills]  WITH CHECK ADD  CONSTRAINT [FK_bills_bills] FOREIGN KEY([userid])
REFERENCES [dbo].[Users] ([userid])
GO
ALTER TABLE [dbo].[bills] CHECK CONSTRAINT [FK_bills_bills]
GO
ALTER TABLE [dbo].[user_department]  WITH CHECK ADD  CONSTRAINT [FK_user_department_Departments] FOREIGN KEY([deptid])
REFERENCES [dbo].[Departments] ([deptid])
GO
ALTER TABLE [dbo].[user_department] CHECK CONSTRAINT [FK_user_department_Departments]
GO
ALTER TABLE [dbo].[user_department]  WITH CHECK ADD  CONSTRAINT [FK_user_department_Users] FOREIGN KEY([userid])
REFERENCES [dbo].[Users] ([userid])
GO
ALTER TABLE [dbo].[user_department] CHECK CONSTRAINT [FK_user_department_Users]
GO
USE [master]
GO
ALTER DATABASE [apautomation] SET  READ_WRITE 
GO
