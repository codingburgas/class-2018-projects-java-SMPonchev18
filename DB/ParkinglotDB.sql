USE [master]
GO
/****** Object:  Database [Parkinglot]    Script Date: 5/31/2022 7:38:46 PM ******/
CREATE DATABASE [Parkinglot]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Parkinglot', FILENAME = N'H:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\Parkinglot.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Parkinglot_log', FILENAME = N'H:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\Parkinglot_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [Parkinglot] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Parkinglot].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Parkinglot] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Parkinglot] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Parkinglot] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Parkinglot] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Parkinglot] SET ARITHABORT OFF 
GO
ALTER DATABASE [Parkinglot] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Parkinglot] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Parkinglot] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Parkinglot] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Parkinglot] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Parkinglot] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Parkinglot] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Parkinglot] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Parkinglot] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Parkinglot] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Parkinglot] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Parkinglot] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Parkinglot] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Parkinglot] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Parkinglot] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Parkinglot] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Parkinglot] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Parkinglot] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Parkinglot] SET  MULTI_USER 
GO
ALTER DATABASE [Parkinglot] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Parkinglot] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Parkinglot] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Parkinglot] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Parkinglot] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Parkinglot] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [Parkinglot] SET QUERY_STORE = OFF
GO
USE [Parkinglot]
GO
/****** Object:  Table [dbo].[Parking]    Script Date: 5/31/2022 7:38:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Parking](
	[Id] [int] NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[AvailableParkingSpaces] [int] NOT NULL,
 CONSTRAINT [PK__Parking__3214EC07A644DF27] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Subscriptions]    Script Date: 5/31/2022 7:38:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Subscriptions](
	[SubscriptionsId] [int] NOT NULL,
	[Duration] [nvarchar](100) NOT NULL,
	[Price] [int] NOT NULL,
 CONSTRAINT [PK__Subscrip__49137A25C9DEDD15] PRIMARY KEY CLUSTERED 
(
	[SubscriptionsId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User]    Script Date: 5/31/2022 7:38:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[UserId] [int] IDENTITY(1,1) NOT NULL,
	[FirstName] [nvarchar](50) NOT NULL,
	[LastName] [nvarchar](50) NOT NULL,
	[Email] [varchar](100) NOT NULL,
	[Username] [nvarchar](50) NOT NULL,
	[Password] [varchar](50) NOT NULL,
	[Role] [int] NOT NULL,
	[ParkingId] [int] NOT NULL,
 CONSTRAINT [PK__User__1788CC4C70480280] PRIMARY KEY CLUSTERED 
(
	[UserId] ASC
)WITH (PAD_INDEX = ON, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, FILLFACTOR = 1, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Vehicle]    Script Date: 5/31/2022 7:38:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Vehicle](
	[VehicleId] [int] NOT NULL,
	[Category] [nvarchar](50) NOT NULL,
	[PlateNumber] [nvarchar](20) NOT NULL,
	[BrandName] [nvarchar](150) NOT NULL,
	[ModelName] [nvarchar](150) NOT NULL,
	[PrakingId] [int] NOT NULL,
	[date] [datetime] NOT NULL,
	[SubscriptionId] [int] NULL,
 CONSTRAINT [PK__Vehicle__476B54928FFBD441] PRIMARY KEY CLUSTERED 
(
	[VehicleId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[VehicleRegistration]    Script Date: 5/31/2022 7:38:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VehicleRegistration](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[VehicleId] [int] NULL,
	[DateTime] [datetime2](7) NULL,
	[Event] [int] NULL,
 CONSTRAINT [PK_VehicleRegistration] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[VehicleSubscription]    Script Date: 5/31/2022 7:38:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VehicleSubscription](
	[VehicleId] [int] NOT NULL,
	[SubscriptionId] [int] NOT NULL,
 CONSTRAINT [PK_VehicleSubscription] PRIMARY KEY CLUSTERED 
(
	[VehicleId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[VehicleRegistration] ADD  CONSTRAINT [DF_VehicleRegistration_DateTime]  DEFAULT (getdate()) FOR [DateTime]
GO
ALTER TABLE [dbo].[User]  WITH CHECK ADD  CONSTRAINT [FK_User.ParkingId] FOREIGN KEY([ParkingId])
REFERENCES [dbo].[Parking] ([Id])
GO
ALTER TABLE [dbo].[User] CHECK CONSTRAINT [FK_User.ParkingId]
GO
ALTER TABLE [dbo].[Vehicle]  WITH CHECK ADD  CONSTRAINT [FK_Vehicle.PrakingId] FOREIGN KEY([PrakingId])
REFERENCES [dbo].[Parking] ([Id])
GO
ALTER TABLE [dbo].[Vehicle] CHECK CONSTRAINT [FK_Vehicle.PrakingId]
GO
ALTER TABLE [dbo].[VehicleRegistration]  WITH CHECK ADD  CONSTRAINT [FK_VehicleRegistration_Vehicle] FOREIGN KEY([VehicleId])
REFERENCES [dbo].[Vehicle] ([VehicleId])
GO
ALTER TABLE [dbo].[VehicleRegistration] CHECK CONSTRAINT [FK_VehicleRegistration_Vehicle]
GO
ALTER TABLE [dbo].[VehicleSubscription]  WITH CHECK ADD  CONSTRAINT [FK_VehicleSubscription_Subscriptions] FOREIGN KEY([SubscriptionId])
REFERENCES [dbo].[Subscriptions] ([SubscriptionsId])
GO
ALTER TABLE [dbo].[VehicleSubscription] CHECK CONSTRAINT [FK_VehicleSubscription_Subscriptions]
GO
ALTER TABLE [dbo].[VehicleSubscription]  WITH CHECK ADD  CONSTRAINT [FK_VehicleSubscription_Vehicle] FOREIGN KEY([VehicleId])
REFERENCES [dbo].[Vehicle] ([VehicleId])
GO
ALTER TABLE [dbo].[VehicleSubscription] CHECK CONSTRAINT [FK_VehicleSubscription_Vehicle]
GO
USE [master]
GO
ALTER DATABASE [Parkinglot] SET  READ_WRITE 
GO